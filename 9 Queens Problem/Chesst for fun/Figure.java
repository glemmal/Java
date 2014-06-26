
public class Figure {
	
	public int column;
	public int row;
	public int columnBefore;
	public int rowBefore;
	public String type;
	public int identifier;
	public ChessBoard board;
	
	Figure() {
		column = 0;
		row = 0;
		columnBefore = 0;
		rowBefore = 0;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public void setName(int identifier) {
		this.identifier = identifier;
	}
	
	public void setupMove() {
		rowBefore = row;
		columnBefore = column;
	}
	
	public void turnBack() {
		board.resetPoint(row, column);
		column = columnBefore;
		row = rowBefore;
		board.setPoint(row, column);
	}
	
}
