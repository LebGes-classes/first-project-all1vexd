import java.util.Scanner;

public class Menu1 {
	private final Game1 game;
	
	public Menu1() {
		this.game = new Game1();
	}
	
	public void menuDisplay() {
		System.out.println("Welcome to my game 'Maze'!");
		System.out.println("Write '1' to start game.");
		System.out.println("Write '2' to exit the game.");
		System.out.println("Write '3' to view Game controls.");
	}
	
	public void currentMenuDisplay() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Write any letter to return to Main Menu.");
		char choice = scan.next().charAt(0);
		for (char c : "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".toCharArray()) {
			if (choice == c) {
				System.out.println();
				game.clearConsole();
				start();
			}
		}
	}
	
	public void start() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			menuDisplay();
			System.out.println("Choose the option:");
			int selectedOption = scan.nextInt();
			if (selectedOption == 1) {
				game.play();
				return;
			} else if (selectedOption == 2) {
				System.out.println();
				System.out.println("Thanks for playing! See u later, bye!");
				System.out.println();
				break;
			} else if (selectedOption == 3) {
				game.clearConsole();
				System.out.println();
				System.out.println("Press 'w' to go upstairs");
				System.out.println("Press 'a' to go to the right");
				System.out.println("Press 'd' to go to the left");
				System.out.println("Press 's' to go down");
				System.out.println();
				currentMenuDisplay();
				break;
			} else {
				System.out.println("Wrong choice! Use one of the '1' / '2' / '3'");
			}				
		}
	}
}