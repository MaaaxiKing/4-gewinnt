public class Game {

	Board board = new Board();
	Player player1 = new Player(1, '○');
	Player player2 = new Player(2, '●');
	Player currentPlayer = player1;
	
	void play() {
		do {
			board.print();
			instruct(String.format("Spieler %d, bitte gib eine Spaltennummer ein.", currentPlayer.number));
			int columnIndex = readColumnInput() - 1;
			while (columnIndex < 0 || columnIndex > board.columns - 1 || board.isColumnFull(columnIndex)) {
				if (board.isColumnFull(columnIndex)) {
					instruct("Die Spalte ist voll! Wähle eine andere Spalte!");
				} else if (columnIndex < 0) {
					instruct("Achtung, die eingegebene Spaltennummer darf 1 nicht unterschreiten! Wähle eine andere Spalte!");
				} else if (columnIndex > 6) {
					instruct("Achtung, die eingegebene Spaltennummer darf 7 nicht überschreiten! Wähle eine andere Spalte!");
				}
				columnIndex = readColumnInput();
			}
			board.place(columnIndex, currentPlayer.symbol);
			board.print();
			if (!isWon()) {
				switchPlayers();
			} else {
				congratulate(currentPlayer);
			}
		} while (!isWon());
	}
	
	private int readColumnInput() {
		boolean readOK = false;
		int result = 0;
		do {
			try {
				result = Integer.valueOf((char) System.in.read());
				readOK = true;
			} catch(Exception e) {
				System.out.println("ungültig!");
				instruct("Bitte gib etwas anderes ein!");
			}
		} while(!readOK);
		/*if(!readOK) {
			throw new RuntimeException("Eingabe final gescheitert");
		}*/
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