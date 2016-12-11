package nl.mieras.made.table;

public class TableDefinition {

	private String fileName;	
	private String selectQuery;
	private String fromQuery;
	private String sortColumn;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSelectQuery() {
		return selectQuery;
	}
	public void setSelectQuery(String selectQuery) {
		this.selectQuery = selectQuery;
	}
	public String getFromQuery() {
		return fromQuery;
	}
	public void setFromQuery(String fromQuery) {
		this.fromQuery = fromQuery;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
}
