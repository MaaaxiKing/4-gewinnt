public class Board {
	
	int rows = 6;
	int columns = 7;
	String field = "| %c ";
	String emptyField = String.format(field, ' ');
	String[] columnNumberRow = new String[columns]; {for (int columnIndex=0; columnIndex < columns; columnIndex++) { columnNumberRow[columnIndex] = String.format(field, columnIndex);}};
	String[][] playboard = new String[rows][columns]; {for (int rowIndex=0; rowIndex < rows; rowIndex++) { for (int columnIndex=0; columnIndex < columns; columnIndex++) { playboard[rowIndex][columnIndex] = emptyField;}}};
	String[] board = new String[2]; {board[0] = columnNumberRow;}

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
		for (int rowIndex=0, columnIndex=0; rowIndex < rows + 1 && columnIndex < columns; rowIndex++, columnIndex++) {
			System.out.print(board[rowIndex][columnIndex]);
			if (columnIndex == columns - 1) {
				System.out.println();
			}
		}
	}

	void place(int columnIndex, char symbol) {
		playboard[getLevel(columnIndex)][columnIndex] = String.format(field, symbol);
	}

	private int getLevel(int columnIndex) {
		for (int rowIndex = rows; rowIndex >= 0; rowIndex--) {
			if (playboard[columnIndex][rowIndex] == emptyField) {
				return rowIndex + rows;
			}
		}
		return rows;
	}

	boolean are4inALine() {
		for (int rowIndex=0, columnIndex=0; rowIndex < rows && columnIndex < columns; rowIndex++, columnIndex++) {
			if (playboard[rowIndex][columnIndex] != emptyField && (canCheckFromRow(rowIndex) && are4inAColumn(columnIndex, rowIndex) || canCheckFromColumn(columnIndex) && are4inARow(rowIndex, columnIndex) || are4inADiagonal())) {
				return true;
			}
		}
		return false;
	}

	private boolean canCheckFromRow(int index) {
		return !(index > 2);
	}

	private boolean are4inAColumn(int index, int starterRowIndex) {
		return (playboard[starterRowIndex][index] == playboard[starterRowIndex + 1][index] && playboard[starterRowIndex + 1][index] == playboard[starterRowIndex + 2][index] && playboard[starterRowIndex + 2][index] == playboard[starterRowIndex + 3][index]);
	}

	private boolean canCheckFromColumn(int index) {
		return !(index > 3);
	}

	private boolean are4inARow(int index, int starterColumnIndex) {
		return (playboard[index][starterColumnIndex] == playboard[index][starterColumnIndex + 1] && playboard[index][starterColumnIndex + 1] == playboard[index][starterColumnIndex + 2] && playboard[index][starterColumnIndex + 2] == playboard[index][starterColumnIndex + 3]);
	}

	private boolean are4inADiagonal() {
		return are4inAnUpwardsDiagonal(0,0) || are4inADownwardsDiagonal(0,0);
	}

	private boolean are4inAnUpwardsDiagonal(int startingRowIndex, int startingColumnIndex) {
		if (playboard[startingRowIndex][startingColumnIndex] == playboard[startingRowIndex + 1][startingColumnIndex + 1] && playboard[startingRowIndex][startingColumnIndex] == playboard[startingRowIndex + 2][startingColumnIndex + 2] && playboard[startingRowIndex][startingColumnIndex] == playboard[startingRowIndex + 3][startingColumnIndex + 3]) {
			return true;
		}
		return false;
	}
	
	private boolean are4inADownwardsDiagonal(int startingRowIndex, int startingColumnIndex) {
		if (playboard[startingRowIndex][startingColumnIndex] == playboard[startingRowIndex + 1][startingColumnIndex + 1] && playboard[startingRowIndex][startingColumnIndex] == playboard[startingRowIndex + 2][startingColumnIndex + 2] && playboard[startingRowIndex][startingColumnIndex] == playboard[startingRowIndex + 3][startingColumnIndex + 3]) {
			return true;
		}
		return false;
	}
}