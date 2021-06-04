import java.util.Scanner;

public class Game {

	Board board = new Board();
	Player player1 = new Player(1, '○');
	Player player2 = new Player(2, '●');
	Player currentPlayer = player1;
	Scanner input = new Scanner(System.in);
	
	void play() {
		while (!isWon()) {
			board.print();
			instruct(String.format("Spieler %d, bitte gib eine Spaltennummer ein.", currentPlayer.number));
			int columnIndex = readColumnInput() - 1;
			while (!isColumnValid(columnIndex)) {
				if (columnIndex < 0) {
					instruct("Achtung, die eingegebene Spaltennummer darf 1 nicht unterschreiten! Wähle eine andere Spalte!");
				} else if (columnIndex >= board.columns) {
					instruct("Achtung, die eingegebene Spaltennummer darf 7 nicht überschreiten! Wähle eine andere Spalte!");
				} else if (board.isColumnFull(columnIndex)) {
					instruct("Die Spalte ist voll! Wähle eine andere Spalte!");
				}
				columnIndex = readColumnInput() - 1;
			}
			board.place(columnIndex, currentPlayer.symbol);
			if (!isWon()) {
				switchPlayers();
			}
		}
		congratulate(currentPlayer);
	}
	
	private boolean isColumnValid(int columnIndex) {
		if (isColumnNumberValid(columnIndex)) {
			return !board.isColumnFull(columnIndex);
		}
		return false;
	}
	
	private boolean isColumnNumberValid(int columnIndex) {
		return 0 <= columnIndex && columnIndex < board.columns;
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
	
	private void switchPlayers() {
		switch (currentPlayer.number) {
			case 1: currentPlayer = player2; break;
			case 2: currentPlayer = player1;
		}
	}
	
	private void instruct(String instruction) {
		System.out.println(instruction);
	}
	
	private boolean isWon() {
		return board.are4inALine();
	}
	
	private void congratulate(Player player) {
		System.out.println(String.format("Gewonnen hat Spieler %d.", currentPlayer.number));
	}
}