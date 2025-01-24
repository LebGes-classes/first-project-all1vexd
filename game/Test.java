import java.util.Random;

public class Test {
	
	private final char[] alphabet = {'#', '*'};
	private char[][] map = new char [6][6];
	
	public void generation(){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Random random = new Random();
				int number = random.nextInt(2);
				map[i][j] = alphabet[number];
			}
		}
		map[0][0] = 'S';
		map[5][5] = 'F';
	}
	
	public void output() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*public boolean proverka1() {
	public boolean proverka2() {
		while (true) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 'S' && j+1 < 6 && map[i][j+1] != '#'){
						map[i][j] = '.';
						map[i][j+1] = 'S';
					} else if (map[i][j] == 'S' && map[i][j+1] == '#' && i+1 < 6) {
						map[i][j] = '.';
						map[i+1][j] = 'S';
					} else if ((map[i][j+1] == '#' || j+1 < 6) && (map[i+1][j] == '#'|| i+1 < 6) && j-1 >= 0) {
						while (map[i+1][j] != '.') {
							j = j - 1;
						}
						map[i+1][j] = 'S';
						map[i][j] = '.'
					}
				}
			}
		}
	}*/
	
	public boolean proverka() {
		
		char [][] visited = new char [6][6];
		char [][] map1 = new char [6][6];
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				map1[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1[i].length; j++) {
				if (map1[5][5] == 'S') {
					return true;
				}
				else if (map1[i][j] == 'S' && j+1 < 6 && map1[i][j+1] != '#' && visited[i][j+1] != '*') {
					map1[i][j] = '.';
					visited[i][j] = '*';
					map1[i][j+1] = 'S';
				} else if (map1[i][j] == 'S' && i+1 < 6 && map1[i+1][j] != '#' && visited[i+1][j] != '*') {
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
			flag = proverka();
		}
		return map;
	}
	
}