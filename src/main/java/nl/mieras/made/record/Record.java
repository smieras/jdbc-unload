package nl.mieras.made.record;

public class Record {
	
	private String row;

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return row;
	}	
}
