package nl.mieras.made.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.mieras.made.configuration.Configuration;
import nl.mieras.made.mapper.RecordMapper;
import nl.mieras.made.record.Record;

@Component
public class JdbcItemReader {
	
	@Autowired
	private Configuration configuration;	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private RecordMapper recordMapper;
	@Autowired
	private QueryProvider queryProvider;
	
	public JdbcPagingItemReader<Record> getJdbcPagingItemReader(String select, String from, String keyColumn) {
		JdbcPagingItemReader<Record> reader = new JdbcPagingItemReader<>();
		reader.setDataSource(dataSource);
		reader.setRowMapper(recordMapper);
		reader.setQueryProvider(queryProvider.getQueryProvider(select, from, keyColumn));
		reader.setPageSize(configuration.getPageSize());
		try {
			reader.afterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reader;
	}
}
