public class Board {

	int columns = 7;
	int rows = 6;
	String empty = " ";
	String[][] board = new String[columns][rows];
	
	Board() {
		for (int column=0; column < column; column++) {//wieso nicht ohne = 0?
			board[column][0] = String.format("| %d ", column);
		}
	}
}