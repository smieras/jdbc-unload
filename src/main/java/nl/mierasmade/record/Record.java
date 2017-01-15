package nl.mierasmade.record;

public class Record {
	
	private String row;

	public void setRow(String row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return row;
	}	
}
