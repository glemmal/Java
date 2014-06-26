
public class QueensProblem {

	static final int DIMENSION = 8;  
	
	public static void main(String[] args) { 
		new QueensProblem();
		
	}
	
	public QueensProblem() {
		int[] queens = enumerate(0, createEmptyQueens());
		printMatrix(queens);
	}
	
	private int[] createEmptyQueens() {
		//index: row and queen, value: column
		int[] queens = new int[DIMENSION];
		//default values: -1
		for (int i = 0; i < queens.length; i++) {
			queens[i] = -1;
		}
		return queens;
	}

	private void printMatrix(int[] queens) {
		String output = "";
		for(int y=0; y<DIMENSION; y++) {
			for(int x=0; x<DIMENSION; x++) {
				output += (queens[y] == x ? 1 : 0) + " ";
			}
			output += "\n";
		}
		System.out.println(output);
	}
	
	private boolean conflictingPositions(int x1, int y1, int x2, int y2) {
			//same row
		return (x1 == x2) 
			//Ascending diagonal
			|| ((y1 - x1) == (y2 - x2))
			//descending diagonal
		    || ((x1 + y1) == (x2 + y2));
	}
	
	private boolean isQueenThreatened(int x, int y, int[] queens) {
		//go through all queens to check if any queen is threatened
		for (int i = 0; i < queens.length; i++) {
			// no queen is set?
			if (queens[i] == -1) return false;
			// queen is set
			if (conflictingPositions(x, y, queens[i], i)) return true;
		}		
		return false;
	}
	
	private int[] enumerate(int y, int[] queens) {

		if (y >= DIMENSION) return queens;
		
		for (int x = 0; x < DIMENSION; x++) {
			if (!isQueenThreatened(x, y, queens)) {
				int[] nextQueens = queens.clone();
				//set queen no point
				nextQueens[y] = x;
				//again and again and again
				int[] solution = enumerate(y + 1, nextQueens);
				if (solution != null) return solution;
			}
		}
		
		return null;
	}
	
}
