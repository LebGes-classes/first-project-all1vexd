import java.util.Random;

public class AutoGeneration {
	
	private final char[] alphabet = {'#', '*'};
	private int sizeOfField = 10;
	private char[][] map = new char [sizeOfField][sizeOfField];
	
	public int getSizeOfField() {
		return sizeOfField;
	}
	
	public void generation(){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Random random = new Random();
				int number = random.nextInt(alphabet.length);
				map[i][j] = alphabet[number];
			}
		}
		map[0][0] = 'S';
		map[sizeOfField - 1][sizeOfField - 1] = 'F';
	}
	
	public void output() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean check() {
		
		char [][] visited = new char [sizeOfField][sizeOfField];
		char [][] map1 = new char [sizeOfField][sizeOfField];
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				map1[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				if (map1[sizeOfField - 1][sizeOfField - 1] == 'S') {
					return true;
				}
				else if (map1[i][j] == 'S' && j+1 < sizeOfField && map1[i][j+1] != '#' && visited[i][j+1] != '*') {
					map1[i][j] = '.';
					visited[i][j] = '*';
					map1[i][j+1] = 'S';
				} else if (map1[i][j] == 'S' && i+1 < sizeOfField && map1[i+1][j] != '#' && visited[i+1][j] != '*') {
					map1[i][j] = '.';
					visited[i+1][j] = '*';
					map1[i+1][j] = 'S';
				} else if (map1[i][j] == 'S' && j-1 >= 0 && map1[i][j-1] != '#' && visited[i][j-1] != '*') {
					map1[i][j] = '.';
					visited[i][j-1] = '*';
					map1[i][j-1] = 'S';
				} else if (map1[i][j] == 'S' && i-1 >= 0 && map1[i-1][j] != '#' && visited[i-1][j] != '*') {
					map1[i][j] = '.';
					visited[i-1][j] = '*';
					map1[i-1][j] = 'S';
				}
			}	
		}
		return false;
	}
	public char[][] resault() {
		boolean flag = false;
		while (!flag) {
			generation();
			flag = check();
		}
		return map;
	}
	
}