package nl.mieras.made.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryProvider {
	
	@Autowired
	private DataSource dataSource;
	
	public PagingQueryProvider getQueryProvider(String select, String from, String keyColumn) {
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
