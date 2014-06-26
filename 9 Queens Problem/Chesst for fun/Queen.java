
public class Queen extends Figure{
	
	public final static String TYPE_QUEEN = "Queen";
	
	public Queen(int row, int column, int identifier, ChessBoard board) {
		this.board = board;
		this.type = TYPE_QUEEN;
		this.row = row;
		this.column = column;
		this.rowBefore = row;
		this.columnBefore = column;
		this.identifier = identifier;
	}
	
	public boolean moveLeftOrRight(int steps) {
		setupMove();
		if(((column+steps)>=0) && ((column+steps) <= ChessBoard.BOARD_WIDTH_LENGTH)) {
			board.resetPoint(row, column);
			column = column+steps;
			board.setPoint(row, column);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean moveUpOrDown(int steps) {
		if(((row-steps)>=0) && ((row-steps) <= ChessBoard.BOARD_WIDTH_LENGTH)) {
			setupMove();
			board.resetPoint(row, column);
			row = row-steps;
			board.setPoint(row, column);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean moveDescendingDiagonal(int steps) {
		if(((column-steps)>=0) && ((column-steps) <= ChessBoard.BOARD_WIDTH_LENGTH)) {
			setupMove();
			board.resetPoint(row, column);
			row = column-steps;
			column = column-steps;
			board.setPoint(row, column);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean moveAscendingDiagonal(int steps) {
		if(((column-steps)>=0) && ((column-steps) <= ChessBoard.BOARD_WIDTH_LENGTH)) {
			setupMove();
			board.resetPoint(row, column);
			row = column-steps;
			column = column+steps;
			board.setPoint(row, column);
			return true;
		} else {
			return false;
		}
		
	}
		
}
