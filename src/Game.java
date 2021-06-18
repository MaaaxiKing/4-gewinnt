import java.util.Scanner;

public class Game {

	Board board = new Board();
	Player player1 = new Player(1, '○'), player2 = new Player(2, '●'), currentPlayer;
	Scanner input = new Scanner(System.in);
	
	void play() {
		while (!isWon() && !isDraw()) {
			switchPlayers();
			board.print();
			instruct(String.format("Spieler %d, bitte gib eine Spaltennummer ein.", currentPlayer.number));
			int columnIndex = readColumnInput() - 1;
			while (!isColumnValid(columnIndex)) {
				if (columnIndex < 0) {
					instruct("Achtung, die eingegebene Spaltennummer darf 1 nicht unterschreiten! Wähle eine andere Spalte!");
				} else if (columnIndex >= board.COLUMNS) {
					instruct("Achtung, die eingegebene Spaltennummer darf 7 nicht überschreiten! Wähle eine andere Spalte!");
				} else if (board.isColumnFull(columnIndex)) {
					instruct("Die Spalte ist voll! Wähle eine andere Spalte!");
				}
				columnIndex = readColumnInput() - 1;
			}
			board.place(columnIndex, currentPlayer.symbol);
		}
		board.print();
		if (isWon()) {
			congratulate(currentPlayer);
		} else if (isDraw()) {
			System.out.println("Unentschieden!");
		}
	}
	
	private boolean isWon() {
		return board.are4inALine();
	}
	
	private boolean isDraw() {
		for (int columnIndex=0; columnIndex < board.COLUMNS; columnIndex++) {
			if (isColumnValid(columnIndex)) {
				return false;
			}
		}
		return true;
	}
	
	private void switchPlayers() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else if (currentPlayer == player2) {
			currentPlayer = player1;
		} else {
			 currentPlayer = player1;
		}
	}
	
	private boolean isColumnValid(int columnIndex) {
		if (isColumnNumberValid(columnIndex)) {
			return !board.isColumnFull(columnIndex);
		}
		return false;
	}
	
	private boolean isColumnNumberValid(int columnIndex) {
		return 0 <= columnIndex && columnIndex < board.COLUMNS;
	}
	
	private int readColumnInput() {
		boolean readOK = false;
		int result = 0;
		do {
			try {
				result = input.nextInt();
				readOK = true;
			} catch(Exception e) {
				System.out.println("ungültig!");
				instruct("Bitte gib etwas anderes ein!");
			}
		} while(!readOK);
		return result;
	}
	
	private void instruct(String instruction) {
		System.out.println(instruction);
	}
	
	private void congratulate(Player player) {
		System.out.println(String.format("Gewonnen hat Spieler %d.", player.number));
	}
}