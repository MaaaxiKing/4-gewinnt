import java.util.HashMap;
import java.util.Map;

public class Game {
	
	int columns = 7;
	int rows = 6;
	String empty = " ";
	String[][] board = new String[columns][rows]{new String[]{}"| 1 | 2 | 3 | 4 | 5 | 6 | 7 |"
										+ "|   |   |   |   |   |   |   |"
										+ "|   |   |   |   |   |   |   |"
										+ "|   |   |   |   |   |   |   |"
										+ "|   |   |   |   |   |   |   |"
										+ "|   |   |   |   |   |   |   |"
										+ "|   |   |   |   |   |   |   |"};
	int[] spalteFuellstand = new int[7];
	int player = 1;
	Map<Integer, String> playerSymbols = new HashMap<Integer, String>();
	playerSymbols.put(1, "○");
	playerSymbols.put(2, "●");
	
	void printBoard() {
		System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
		for (int row = 0, int column = 0; row < board[0].length - 2 && column < board.length; row++, column++) {
			System.out.println(String.format("| %c | %c | %c | %c | %c | %c | %c |", board[column][row]));
		}
				// end of if else if (SpielFeld[ZeilenCounter][SpaltenCounter] == 1) { System.out.print("| " + "X" + " "); } 
				// end of if-else else if (SpielFeld[ZeilenCounter][SpaltenCounter] == 2) { System.out.print("| " + "O" + " "); }
				// end of if-else } // end of for System.out.print("|"); System.out.println(); System.out.println("|___|___|___|___|___|___|___|"); } 
				// end of for System.out.println(); } 
				// end of private static void SpielFeldAusgeben private static void Spielerwechsel() {
				// Spielerwechsel if (SpielerEins == true) {
				SpielerEins = false; } // end of if else {
			SpielerEins = true; }
		// end of if-else } 
		// end of private static void Spielerwechsel private static void Spalteneingabe() { 
		// Spalteneingabe durch Spieler eins oder zwei try{ int Spieler; Spalte = 0; String EingabeA;
		if (SpielerEins == true) {
			Object EingabeA = Input.readString("Spieler 1: Bitte Spaltennummer angeben: "); }
		// end of if else { EingabeA = Input.readString("Spieler 2: Bitte Spaltennummer angeben: "); } 
		// end of if-else // Prüfen der Eingabe auf einen Wert zwischen 1 und 7 Spalte = Integer.parseInt(EingabeA); }
		  "catch"(Exception ) ; {
			//System.out.println("Bitte Zahl zwischen 1 und 7 eingeben"); }
			if (Spalte < 1 || Spalte > 7) { 
				System.out.println(); System.out.println("Achtung! Die eingegebene Spaltennummer muss zwischen 1 und 7 liegen!");
				Spalteneingabe(); }
			else if (spalteFuellstand[Spalte - 1] > 5) { 
				System.out.println("Spalte voll!!!!"); Spalteneingabe(); } 
			else { spalteFuellstand[Spalte - 1]++; }
			private static void Spalteneingabe() {
		
	}
			private static void Spielzug() {
				if (SpielerEins == true) {
					SpielFeld[6 - spalteFuellstand[Spalte - 1]][Spalte - 1] = 1; }
				int s;
				// end of if else { SpielFeld[6 - spalteFuellstand[Spalte - 1]][Spalte - 1] = 2; }
				// end of if-else }// end of private static void Spielzug private static void Gewinnbedingung() { boolean a=false; int s; 
				if (SpielerEins == true) { s=1; }
				else { s=2; }
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
		
	}
}