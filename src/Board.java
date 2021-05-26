public class Board {

	int columns = 7;
	int rows = 6;
	String[][] board = new String[columns][rows];
	String firstFieldHalf = "| ";
	String secondFieldHalf = "%s ";
	String emptyField = "|  ";
	
	Board() {
		for (int column = 0; column < columns; column++) {//wieso nicht ohne = 0?
			board[column][0] = String.format("| %d ", column);
		}
	}
	
	boolean isFull(int column) {
		int level = 0;
		for (int row = 0; row < rows; row++) {
			if (board[column][row] != null) {
				level++;
				if (level == 7) {
					return true;
				}
			}
		}
		return false;
	}
	
	void print() {
		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
				System.out.print(board[column][row]);
			}
			System.out.println();
		}
	}
	
	void place(int column, String symbol) {
		board[column][getLevel(column)] = firstFieldHalf + String.format(secondFieldHalf, symbol);
	}

	int getLevel(int column) {
		int row = rows;
		for (row = rows; row > 0; row--) {
			if (board[column][row] == emptyField) {
				return row - 1;
			}
		}
		return row;
	}
}