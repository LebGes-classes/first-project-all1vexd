import java.util.Scanner;

public class Game1 {
	private int coordinateX;
	private int coordinateY;
	private int numberOfLevel;
	private AutoGeneration generation = new AutoGeneration();
	private char[][] map;
	
	
	public void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception E) {
			System.out.println(E);
		}
	}
	
	public void display() {
		System.out.println("The curren level: " + (numberOfLevel + 1));
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Your coordinates: (" + (coordinateX + 1) + "," + (coordinateY + 1 + ")"));
	}
	
	public void updateDisplay(char letter) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'S') {
					map[i][j] = '*';
				}
			}
			map[coordinateY][coordinateX] = letter;
		}
	}	
	
	public void playersMove(char selectedMove) {
		int currentCoordinateX = coordinateX;
		int currentCoordinateY = coordinateY;
		
		switch (selectedMove) {
			case 'w':
				currentCoordinateY--;
				break;
			case 's':
				currentCoordinateY++;
				break;
			case 'a':
				currentCoordinateX--;
				break;
			case 'd':
				currentCoordinateX++;
				break;
			default:
				System.out.println("You choose the wrong way! Use w/a/s/d.");
				return;
		}
		if (currentCoordinateX >= generation.getSizeOfField() || currentCoordinateX < 0 ||
					currentCoordinateY >= generation.getSizeOfField() || currentCoordinateY < 0) {
			clearConsole();
			System.out.println("Oops, there's a wall here! You can't go there!");
			return;
		}
		
		if (map[currentCoordinateY][currentCoordinateX] == '*') {
			coordinateX = currentCoordinateX;
			coordinateY = currentCoordinateY;
			clearConsole();
			updateDisplay('S');
		} else if (map[currentCoordinateY][currentCoordinateX] == 'F'){
			coordinateX = currentCoordinateX;
			coordinateY = currentCoordinateY;
			clearConsole();
			updateDisplay('V');
		} else {
			clearConsole();
			System.out.println("Oops, there's a wall here! You can't go there!");
			return;
		}
	}
	
	public boolean win() {
		return map[coordinateY][coordinateX] == 'V';
	}
	
	public void play() {
		clearConsole();
		this.map = generation.resault();
		Scanner scan = new Scanner(System.in);
		while (true) {
			display();
			if (win()) {
				System.out.println("Write '1' to next level!");
				System.out.println("Write '2' to end  game!");
				int choos = scan.nextInt();
				if (choos == 1) {
					numberOfLevel += 1;
					coordinateX = 0;
					coordinateY = 0;
					clearConsole();
					play();
				}
				else {
					System.out.println("Thanks for playing! See u later, bye!");
				}
				return;
			}
			System.out.println("Enter the direction");
			char move = scan.next().charAt(0);
			playersMove(move);
		}
	}
	
	
}
