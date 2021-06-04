import java.util.Arrays;

public class Board {
	
	int playrows = 6;
	int rows = playrows + 1;
	int columns = 7;
	String field = "| %c ";
	String emptyField = String.format(field, ' ');
	String[] columnNumberRow = new String[columns]; {for (int columnIndex=0; columnIndex < columns; columnIndex++) { columnNumberRow[columnIndex] = String.format(field, (char)(columnIndex + '1'));}};
	String[][] playboard = new String[playrows][columns]; {for (int rowIndex=0; rowIndex < playrows; rowIndex++) { for (int columnIndex=0; columnIndex < columns; columnIndex++) { playboard[rowIndex][columnIndex] = emptyField;}}};
	String[][] board = new String[rows][columns]; {for (int rowIndex=0; rowIndex < rows; rowIndex++) { for (int columnIndex=0; columnIndex < columns; columnIndex++) { if (rowIndex == 0) {board[rowIndex][columnIndex] = columnNumberRow[columnIndex];} else { board[rowIndex][columnIndex] = playboard[rowIndex - 1][columnIndex];}}}};
	
	boolean isColumnFull(int columnIndex) {
		return getLevel(columnIndex) == playrows;
	}

	void print() {
		System.out.println(Arrays.deepToString(board).replace(" [", "\n").replace(", ", "").replace(",", "").replace("[", "").replace("]", ""));
	}

	void place(int columnIndex, char symbol) {
		playboard[playrows - 1 - getLevel(columnIndex)][columnIndex] = String.format(field, symbol);
		updateBoard();
	}
	
	private int getLevel(int columnIndex) {
		int level = 0;
		while (playboard[playrows - 1 - level][columnIndex] != emptyField) {
			level++;
		}
		return level;
	}

	boolean are4inALine() {
		for (int rowIndex=0, columnIndex=0; rowIndex < playrows && columnIndex < columns; rowIndex++, columnIndex++) {
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