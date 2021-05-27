public class Game {

	Board board = new Board();
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	Player currentPlayer = player1;
	KeyboardInput input = new KeyboardInput();
	
	void start() {
		continuee();
	}
	
	void continuee() {
		while (!isWon()) {
			instruct(String.format("Spieler %d, bitte gib eine Spaltennummer ein.", currentPlayer.number));
			int columnIndex = input.getInputColumn() - 1;
			if (canPlace(columnIndex)) {
				board.place(columnIndex, currentPlayer.symbol);
			} else if (board.isColumnFull(columnIndex)) {
				instruct("Die Spalte ist voll! Wähle eine andere Spalte!");
			} else if (columnIndex < 1) {
				instruct("Achtung, die eingegebene Spaltennummer darf 1 nicht unterschreiten! Wähle eine andere Spalte!");
			} else if (columnIndex > 7) {
				instruct("Achtung, die eingegebene Spaltennummer darf 7 nicht überschreiten! Wähle eine andere Spalte!");
			}
			if (!isWon()) {
				switchPlayers();
			}
		}
		congratulate(currentPlayer);
		askRestartOrEnd();
	}
	
	boolean canPlace(int columnIndex) {
		return 0 <= columnIndex && columnIndex >= 6 && !board.isColumnFull(columnIndex);
	}
	
	void switchPlayers() {
		switch (currentPlayer.number) {
			case 1: currentPlayer = player2; break;
			case 2: currentPlayer = player1;
		}
	}
	
	void instruct(String instruction) {
		System.out.println(instruction);
	}
	
	boolean isWon() {
		return board.are4inARow();
	}
	
	void congratulate(Player player) {
		System.out.println(String.format("Gewonnen hat Spieler %d.", currentPlayer.number));
	}
	
	void askRestartOrEnd() {
		if (input.getInputContinue() == "R") {
			board.clear();
			start();
		}
	}
}