package nl.mieras.made.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import nl.mieras.made.table.TableDefinition;

@Component
@ConfigurationProperties
public class Configuration {	

	private String outputDir;
	private char delimiter;
	private char quote;
	private int commitInterval;	
	private int pageSize;
	private List<TableDefinition> tableDefinitions = new ArrayList<>();
	
	public String getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public char getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}	

	public char getQuote() {
		return quote;
	}

	public void setQuote(char quote) {
		this.quote = quote;
	}

	public int getCommitInterval() {
		return commitInterval;
	}

	public void setCommitInterval(int commitInterval) {
		this.commitInterval = commitInterval;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<TableDefinition> getTableDefinitions() {
		return tableDefinitions;
	}	
}
