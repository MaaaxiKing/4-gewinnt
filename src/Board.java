public class Board {

	int rows = 6;
	int columns = 7;
	String[][] playboard = new String[rows][columns];
	String field = "| %s ";
	String emptyField = String.format(field, " ");
	String[] columnNumberRow = new String[] { "| 1 ", "| 2 ", "| 3 ", "| 4 ", "| 5 ", "| 6 ", "| 7 " };
	String[][] board = new String[rows + 1][columns];// pointer on playboard

	Board() {
		board[0] = columnNumberRow;
	}

	boolean isColumnFull(int columnIndex) {
		int level = 0;
		for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
			if (playboard[rowIndex][columnIndex] != null) {
				level++;
				if (level == rows) {
					return true;
				}
			}
		}
		return false;
	}

	void print() {
		for (int rowIndex, columnIndex; rowIndex < rows && columnIndex < columns; rowIndex++, columnIndex++) {
			System.out.print(board[rowIndex][columnIndex]);
			if (columnIndex == columns - 1) {
				System.out.println();
			}
		}
	}

	void place(int columnIndex, String symbol) {
		board[getLevel(columnIndex)][columnIndex] = String.format(field, symbol);
	}

	int getLevel(int columnIndex) {
		int rowIndex = rows;
		for (rowIndex = rows; rowIndex >= 0; rowIndex--) {
			if (playboard[columnIndex][rowIndex] == emptyField) {
				return rowIndex + rows;
			}
		}
		return rows;
	}

	boolean are4inARow() {
		for (int rowIndex, columnIndex; rowIndex < rows && columnIndex < columns; rowIndex++, columnIndex++) {
			if (columntestMakesSense(rowIndex) && checkColumn(columnIndex)
					|| rowtestMakesSense(columnIndex) && checkRow(rowIndex) || checkDiagonal()) {
				return true;
			}
		}
		return false;
	}

	boolean isCheckableFromRow(int index) {
		return !(index > 2);
	}

	boolean checkColumn(int index) {
		if (playboard[int rowIndex + index][index] == playboard[rowIndex + 1][columnIndex] && board.board[rowIndex][columnIndex] == board.board[rowIndex + 2][columnIndex] && board.board[rowIndex][columnIndex] == board.board[rowIndex + 3][columnIndex]) {
			return true;
		}
		return false;
	}

	boolean isCheckableFromColumn(int index) {
		return !(index > 3);
	}

	boolean checkRow(int index) {
		for (int rowIndex, columnIndex; rowIndex < board.rows
				&& columnIndex < board.columns; rowIndex++, columnIndex++) {
			if (board.board[rowIndex][columnIndex] == board.board[rowIndex][columnIndex + 1]
					&& board.board[rowIndex][columnIndex] == board.board[rowIndex][columnIndex + 2]
					&& board.board[rowIndex][columnIndex] == board.board[rowIndex][columnIndex + 3]) {
				return true;
			}
		}
		return false;
	}

	boolean checkDiagonal() {
		return checkDiagonalUpwards() || checkDiagonalDownwards();
	}

	boolean checkDiagonalupwards(int startingRowIndex, int startingColumnIndex) {
		for (int rowIndex, columnIndex; rowIndex < board.rows
				&& columnIndex < board.columns; rowIndex++, columnIndex++) {
			if (board.board[rowIndex][columnIndex] == board.board[rowIndex + 1][columnIndex + 1]
					&& board.board[rowIndex][columnIndex] == board.board[rowIndex + 2][columnIndex + 2]
					&& board.board[rowIndex][columnIndex] == board.board[rowIndex + 3][columnIndex + 3]) {
				return true;
			}
		}
		return false;
	}
	
	void clear() {
		GameLauncher.main();
	}
}