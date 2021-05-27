import java.util.Scanner;

public class KeyboardInput {

	Scanner scanner = new Scanner(System.in);
    
	int getInputColumn() {
		return scanner.nextInt();
	}
	
	String getInputContinue() {
	    return scanner.nextLine();
	}
}