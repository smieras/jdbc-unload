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
package nl.mierasmade.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import nl.mierasmade.configuration.Configuration;
import nl.mierasmade.record.Record;
import nl.mierasmade.util.StringUtils;

@Component
public class RecordMapper implements RowMapper<Record> {
	
	@Autowired
	private Configuration configuration;

	@Override
	public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();		
		int columnCount = rsmd.getColumnCount();
		Record record = new Record();
		Object[] columns = new Object[columnCount];
		for (int i = 1; i < columnCount + 1; i++) {
			columns[i - 1] = getColumnValue(rs, i);
		}
		String row = StringUtils.arrayToDelimitedString(columns, configuration.getDelimiter(), configuration.getQuote());
		record.setRow(row);
		return record;		
	}
	
	private Object getColumnValue(ResultSet rs, int index) throws SQLException {
		return JdbcUtils.getResultSetValue(rs, index);
	}
}
