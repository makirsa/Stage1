
public class Board {
	
	private static int rows = 6; //there are six rows in the board of connect 4
	private static int columns = 7; //there are seven rows in a board of connect 4
	Piece [][]ourBoard = new Piece[rows][columns];
	
	public Board() {
		for(int row = 0; row < rows; row++) {//putting in rows until "row" is less than "rows" which has a a value of 6
			for(int col = 0; col < columns; col++) { //putting in columns
				ourBoard[row][col]= null; //set null so we can manually place components
			}
		}
	}

}
