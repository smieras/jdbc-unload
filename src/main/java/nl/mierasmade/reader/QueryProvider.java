/*******************************************************************************
 * Copyright 2017 Mieras Made
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package nl.mierasmade.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class QueryProvider {
	
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
