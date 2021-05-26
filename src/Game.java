public class Game {

	Board board = new Board();
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	Player currentPlayer = player1;
	Input input = new Input();
	
	public static void main(String[] args) {
		//instruct();
	}
	
	void switchPlayers() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}
	
	void instruct() {
		int column = input.column;
		if (1 <= column && column >= 7 && !board.isFull(column)) {
			System.out.println(String.format("Spieler %d, bitte gib eine Spaltennummer ein.", currentPlayer.number));
			board.place(column, currentPlayer.symbol);
			switchPlayers();
		} else if (board.isFull(column)) {
			System.out.println("Die Spalte ist voll! Wähle eine andere!");
		} else if (column < 1) {
			System.out.println("Achtung, die eingegebene Spaltennummer darf 1 nicht unterschreiten! Wähle eine andere!");
		} else if (column > 7) {
			System.out.println("Achtung, die eingegebene Spaltennummer darf 7 nicht überschreiten! Wähle eine andere!");
		}
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