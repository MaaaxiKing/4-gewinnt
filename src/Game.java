import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

	Board board = new Board();
	int player = 1;
	Map<Integer, String> playerSymbols = new HashMap<Integer, String>();
	playerSymbols.put(1, "○");
	playerSymbols.put(2, "●");
	
	public static void main(String[] args) {
	}
	
	void printBoard() {
		for (int column; column < board.columns; column++) {
			for (int row; row < board.rows; row++) {
				System.out.print(board[column][row]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	void changePlayers() {
		switch(player) {
			case 1 : player++; break;
			case 2 : player--;
		}
	}
	
	void putIn() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println(String.format("Spieler %d: Bitte Spaltennummer angeben.", player));
		int column = keyboard.nextInt();
		if (1 <= column && column >= 7 && !isFull(column)) {
			level++;
		} else if (isFull(column)) {
			System.out.println("Die Spalte ist voll!");
		} else if (column < 1) {
			System.out.println("Achtung, die eingegebene Spaltennummer darf 1 nicht unterschreiten!");
		} else if (column > 7) {
			System.out.println("Achtung, die eingegebene Spaltennummer darf 7 nicht überschreiten!");
		}
	}
}