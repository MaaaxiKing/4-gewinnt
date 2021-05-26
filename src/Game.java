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
	
	boolean isFull(int column) {
		int level;
		for (column : board.length) {
			for (int row = 1 : board[column].length) {
				if (board[column][row] != null) {
					level++;
					if (level == 7) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/*void Spielzug() {
				if (SpielerEins == true) {
					SpielFeld[6 - spalteFuellstand[Spalte - 1]][Spalte - 1] = 1;}
				boolean a;
				for(int i=0;i<=2;i++) for(int j=0;j<=6;j++) {
					if(SpielFeld [i] [j]==s && SpielFeld [i+1] [j]==s && SpielFeld [i+2] [j] ==s && SpielFeld [i+3] [j] ==s){a=true;}}
				for(int i=0;i<=5;i++) 
					for(int j=0;j<=3;j++) {if(SpielFeld [i] [j]==s && SpielFeld [i] [j+1]==s && SpielFeld [i] [j+2] ==s && SpielFeld [i] [j+3] ==s) {a=true;} } 
				for(int i=0;i<=2;i++) for(int j=0;j<=3;j++) {if(SpielFeld [i] [j]==s && SpielFeld [i+1] [j+1]==s && SpielFeld [i+2] [j+2] ==s && SpielFeld [i+3] [j+3] ==s) {a=true;} }
				if (a==true) { System.out.println ("Gewonnen hat Spieler " + s ); String EingabeEnde = (String) Input.readString("Weiterspielen (0) oder Beenden (1)");
				int Eingabe = Integer.parseInt(EingabeEnde) ; 
				if (Eingabe== 1) { System.exit(0);}
				else if (Eingabe==0) {
					SpielFeldAusgeben(); } } }
			public static void () {
				while (true) { Spalteneingabe(); Spielzug(); SpielFeldAusgeben(); Gewinnbedingung(); Spielerwechsel(); 
				}
				}
	private void Gewinnbedingung() {
		
	}

	private void Spielerwechsel() {
		
	}*/
}