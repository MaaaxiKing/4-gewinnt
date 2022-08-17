import java.util.Arrays;

public class Board {
	
	int PLAYROWS = 6;
	int COLUMNS = 7;
	String field = "| %c ";
	String EMPTY_FIELD = String.format(field, ' ');
	String[] COLUMN_NUMBER_ROW = new String[COLUMNS]; {for (int columnIndex=0; columnIndex < COLUMNS; columnIndex++) { COLUMN_NUMBER_ROW[columnIndex] = String.format(field, (char)(columnIndex + '1'));}};
	String[][] playboard = new String[PLAYROWS][COLUMNS]; {for (int rowIndex=0; rowIndex < PLAYROWS; rowIndex++) { for (int columnIndex=0; columnIndex < COLUMNS; columnIndex++) { playboard[rowIndex][columnIndex] = EMPTY_FIELD;}}};
	
	boolean are4inALine() {
		for (int rowIndex=0; rowIndex < PLAYROWS; rowIndex++)
			for (int columnIndex=0; columnIndex < COLUMNS; columnIndex++)
				if (!playboard[rowIndex][columnIndex].equals(EMPTY_FIELD))
					if (isCheckableFromColumn(columnIndex) && are4inARow(rowIndex, columnIndex) || isCheckableFromRow(rowIndex) && are4inAColumn(columnIndex, rowIndex) || isCheckableFromColumn(columnIndex) && are4inADiagonal(rowIndex, columnIndex)) //direkter Return schlecht, denn, wenn eine Reihe geprüft wird und sie ungültig ist, wird die darunter ignoriert
						return true;
		return false;
	}

	private boolean isCheckableFromRow(int index) {
		return index <= PLAYROWS - 4;
	}

	private boolean are4inAColumn(int index, int baseRowIndex) {
		return playboard[baseRowIndex][index].equals(playboard[baseRowIndex + 1][index]) && playboard[baseRowIndex + 1][index].equals(playboard[baseRowIndex + 2][index]) && playboard[baseRowIndex + 2][index].equals(playboard[baseRowIndex + 3][index]);
	}

	private boolean isCheckableFromColumn(int index) {
		return index <= COLUMNS - 4;
	}

	private boolean are4inARow(int index, int baseColumnIndex) {
		return playboard[index][baseColumnIndex].equals(playboard[index][baseColumnIndex + 1]) && playboard[index][baseColumnIndex + 1].equals(playboard[index][baseColumnIndex + 2]) && playboard[index][baseColumnIndex + 2].equals(playboard[index][baseColumnIndex + 3]);
	}

	private boolean are4inADiagonal(int baseRowIndex, int baseColumnIndex) {
		return are4inAnUpwardsDiagonal(baseRowIndex, baseColumnIndex) || are4inADownwardsDiagonal(baseRowIndex, baseColumnIndex);
	}

	private boolean are4inAnUpwardsDiagonal(int baseRowIndex, int baseColumnIndex) {
		return baseRowIndex >= PLAYROWS - 4 && playboard[baseRowIndex][baseColumnIndex].equals(playboard[baseRowIndex - 1][baseColumnIndex + 1]) && playboard[baseRowIndex][baseColumnIndex].equals(playboard[baseRowIndex - 2][baseColumnIndex + 2]) && playboard[baseRowIndex][baseColumnIndex].equals(playboard[baseRowIndex - 3][baseColumnIndex + 3]);
	}
	
	private boolean are4inADownwardsDiagonal(int baseRowIndex, int baseColumnIndex) {
		return isCheckableFromRow(baseRowIndex) && playboard[baseRowIndex][baseColumnIndex].equals(playboard[baseRowIndex + 1][baseColumnIndex + 1]) && playboard[baseRowIndex][baseColumnIndex].equals(playboard[baseRowIndex + 2][baseColumnIndex + 2]) && playboard[baseRowIndex][baseColumnIndex].equals(playboard[baseRowIndex + 3][baseColumnIndex + 3]);
	}
	
	void print() {
		System.out.println((Arrays.toString(COLUMN_NUMBER_ROW) + "\n" + Arrays.deepToString(playboard)).replace(" [", "\n").replace(", ", "").replace(",", "").replace("[", "").replace("]", ""));
	}
	
	boolean isColumnFull(int columnIndex) {
		return playboard[0][columnIndex] != EMPTY_FIELD;
	}
	
	void place(int columnIndex, char symbol) {
		playboard[PLAYROWS - 1 - getLevel(columnIndex)][columnIndex] = String.format(field, symbol);
	}
	
	private int getLevel(int columnIndex) {
		int level = 0;
		while (playboard[PLAYROWS - 1 - level][columnIndex] != EMPTY_FIELD)
			level++;
		return level;
	}
}