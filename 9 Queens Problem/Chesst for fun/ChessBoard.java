import java.util.HashMap;
import java.util.Map.Entry;


public class ChessBoard{
	
	public int[][] chessBoard;
	//BOARD_WIDTH_LENGTH = real length - 1
	public final static int BOARD_WIDTH_LENGTH = 7;
	HashMap<Integer, Figure> figures;
	
	public ChessBoard() {
		chessBoard = new int[BOARD_WIDTH_LENGTH+1][BOARD_WIDTH_LENGTH+1];
		setupFigures();
		fill();
		placeFigures(this.figures);
	}
	
	public int getBoardDimension() {
		return BOARD_WIDTH_LENGTH;
	}
	
	public void setupFigures() {
		this.figures = new HashMap<Integer, Figure>();
		figures.put(0,new Queen(0,0,0,this));
		figures.put(1,new Queen(0,1,1,this));
		figures.put(2,new Queen(0,2,2,this));
		figures.put(3,new Queen(0,3,3,this));
		figures.put(4,new Queen(0,4,4,this));
		figures.put(5,new Queen(0,5,5,this));
		figures.put(6,new Queen(0,6,6,this));
		figures.put(7,new Queen(0,7,7,this));
	}
	
	public void fill() {
		for(int row=0; row<=BOARD_WIDTH_LENGTH; row++) {
			for(int column=0; column<=BOARD_WIDTH_LENGTH; column++) {
				chessBoard[row][column] = -1;
			}
		}
	}
	
	public void setPoint(int r, int c) {
		chessBoard[r][c] = 8;
	}
	
	public void resetPoint(int r, int c) {
		chessBoard[r][c] = -1;
	}
	
	public int getPoint(int r, int c) {
		return chessBoard[r][c]; 
	}
	
	public boolean isFigureOnPoint(int r, int c) {
		return chessBoard[r][c] == 1;
	}
	
	public boolean figureSameRow(Figure figureOne, Figure figureTwo) {
		return figureOne.getRow() == figureTwo.getRow();
	}
	
	public boolean figureSameColumn(Figure figureOne, Figure figureTwo) {
		return figureOne.getColumn() == figureTwo.getColumn();
	}
	
	public boolean figureAscendingDiagonal(Figure figureOne, Figure figureTwo) {
		return figureOne.getColumn()-figureOne.getRow() == figureTwo.getColumn()-figureTwo.getRow(); 
	}
	
	public boolean figureDescendingDiagonal(Figure figureOne, Figure figureTwo) {
		return figureOne.getRow()-figureOne.getColumn() == figureTwo.getColumn()-figureTwo.getRow(); 
	}
	
	public void placeFigures(HashMap<Integer,Figure> figures) {
		for(Entry<Integer, Figure> figure : figures.entrySet()) {
			placeFigure(figure);
		}
	}
	
	public void placeFigure(Entry<Integer, Figure> figure) {
		setPoint(figure.getValue().getRow(), figure.getValue().getColumn());
	}
	
	public void draw() {
		String output = "---------------------------\n + ";
		for(int firstLine = 1; firstLine <= BOARD_WIDTH_LENGTH+1; firstLine++) output += "c" + firstLine + " ";
		for(int row = 0; row <= BOARD_WIDTH_LENGTH; row++) {
			output += "\nr" + (row+1);
			for(int column = 0; column <= BOARD_WIDTH_LENGTH; column++) {
				if(chessBoard[row][column] > 0) output += " ";
				output += " " + chessBoard[row][column];
			}
		}
		output += "\n---------------------------";
		System.out.println(output);
	}
	
	
}
