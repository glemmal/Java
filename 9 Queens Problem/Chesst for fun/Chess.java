
public class Chess {
	
	private ChessBoard board;
//	private ArrayList<Queen> queens;
	
	public static void main(String[] args) {
		Chess myChess = new Chess();
	}
	
	public Chess() {
		board = new ChessBoard();
		board.draw();
		
		// Theoretischer Zugriff auf die Queens.
		// Es kann mit der ganzen Map gearbeitet werden mit board.figures
		
		Queen queen0 = (Queen) board.figures.get(0);
		Queen queen1 = (Queen) board.figures.get(1);
		Queen queen2 = (Queen) board.figures.get(2);
		Queen queen3 = (Queen) board.figures.get(3);
		Queen queen4 = (Queen) board.figures.get(4);
		Queen queen5 = (Queen) board.figures.get(5);
		Queen queen6 = (Queen) board.figures.get(6);
		Queen queen7 = (Queen) board.figures.get(7);
		
		//TODO: Do what ever you want with the Queens, functions return false if there out of bound.
		queen1.moveUpOrDown(-3);
		queen0.moveUpOrDown(-4);
		//queen0.moveUpOrDown(-2);
		//queen1.moveLeftOrRight(1);
		// queen1.moveAscendingDiagonal(-1);
		board.draw();
		
		// TODO: Ascending Funktion stimmt noch nicht. Muss ich nochmal nachsehen
		
		if(board.figureSameRow(queen0, queen1)) System.out.println("Queens are in the Same row!");
		if(board.figureDescendingDiagonal(queen0, queen1)) System.out.println("figureDescendingDiagonal");
		if(board.figureAscendingDiagonal(queen0, queen1)) System.out.println("figureAscendingDiagonal");
		
		
	}
	
	public boolean checkQueen(Figure q) {
		for(int qCheck=0; qCheck<=board.getBoardDimension(); qCheck++) {
			if(
					board.figureSameRow(q, board.figures.get(qCheck)) && 
					board.figureSameColumn(q, board.figures.get(qCheck)) && 
					board.figureDescendingDiagonal(q, board.figures.get(qCheck)) && 
					board.figureAscendingDiagonal(q, board.figures.get(qCheck))) {
				return true;
			}
		}
		
		return false;
	}
	
//	public void enumerate(int q) {
//			board.figures.get(q);
//			for(int c=0; c<=board.getBoardDimension(); c++ ) {
//				if(checkQueen)
//			}
//	}
	
	
}
