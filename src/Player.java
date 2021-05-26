import java.util.Map;

public class Player {

	Map<Integer, String> symbolOfPlayer = Map.of(1, "○", 2, "●");
	String symbol;
	int number;
	
	Player(int number) {
		symbol = symbolOfPlayer.get(number);
		this.number = number;
	}
}