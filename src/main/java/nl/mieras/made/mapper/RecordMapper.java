package nl.mieras.made.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;


import nl.mieras.made.configuration.Configuration;
import nl.mieras.made.record.Record;
import nl.mieras.made.util.StringUtils;

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
