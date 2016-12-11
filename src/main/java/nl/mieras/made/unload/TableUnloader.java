package nl.mieras.made.unload;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.mieras.made.configuration.Configuration;
import nl.mieras.made.reader.JdbcItemReader;
import nl.mieras.made.record.Record;
import nl.mieras.made.table.TableDefinition;

@Component
public class TableUnloader {
	
	@Autowired
	private JdbcItemReader jdbcReader;
	@Autowired
	private Configuration configuration;
	
	// Entry point
	@PostConstruct
	private void unloadTables() {
		
		for (TableDefinition tableDefinition : configuration.getTableDefinitions()) {			
			JdbcPagingItemReader<Record> reader = jdbcReader.getJdbcPagingItemReader(tableDefinition.getSelectQuery(), tableDefinition.getFromQuery(), tableDefinition.getSortColumn());
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(configuration.getOutputDir() + tableDefinition.getFileName(), true))) {
				int count = 0;
				List<Record> records = new ArrayList<>();
				Record record = null;
				while((record = reader.read()) != null) {
					records.add(record);
					count++;
					
					if (count == configuration.getCommitInterval()) {
						writeRecords(bw, records);						
						records = new ArrayList<>();				
						count = 0;
					}					
				}				
				
				writeRecords(bw, records);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

	private void writeRecords(BufferedWriter bw, List<Record> records) throws IOException {
		for (Record line : records) {
			bw.write(line.toString());
			bw.newLine();
		}
	}
}
