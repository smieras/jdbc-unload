package nl.mierasmade.configuration;

import javax.sql.DataSource;
import nl.mierasmade.mapper.RecordMapper;
import nl.mierasmade.record.Record;
import nl.mierasmade.table.TableDefinition;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy
@Configuration
public class ReaderConfiguration {
	
	@Autowired
	private ExternalConfiguration externalConfiguration;	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private RecordMapper recordMapper;
	
	@Bean	
	@Scope("prototype")
	public JdbcPagingItemReader<Record> jdbcPagingItemReader(TableDefinition tableDefinition) {		
		JdbcPagingItemReader<Record> reader = new JdbcPagingItemReader<>();		
		reader.setDataSource(dataSource);
		reader.setRowMapper(recordMapper);
		reader.setQueryProvider(pagingQueryProvider(tableDefinition.getSelectQuery(), tableDefinition.getFromQuery(), tableDefinition.getSortColumn()));
		reader.setPageSize(externalConfiguration.getPageSize());
		try {
			reader.afterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reader;
	}
	
	@Bean	
	@Scope("prototype")
	public PagingQueryProvider pagingQueryProvider(String select, String from, String keyColumn) {
		SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();
		provider.setSelectClause(select);
		provider.setFromClause(from);
		provider.setSortKey(keyColumn);
		provider.setDataSource(dataSource);
		try {
			return provider.getObject();
		} catch (Exception e) {
			throw new IllegalStateException();
		}
	}
}
