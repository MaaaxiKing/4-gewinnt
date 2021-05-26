public class Board {

	int columns = 7;
	int rows = 6;
	String empty = " ";
	String[][] board = new String[columns][rows];
	
	Board() {
		for (int column = 0; column < columns; column++) {//wieso nicht ohne = 0?
			board[column][0] = String.format("| %d ", column);
		}
	}
	
	boolean isFull(int column) {
		int level;
		for (int row = 1 : board[column]) {
			if (board[column][row] != null) {
				level++;
				if (level == 7) {
					return true;
				}
			}
		}
		return false;
	}
}