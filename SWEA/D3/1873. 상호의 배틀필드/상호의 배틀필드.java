import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			int x = 0, y = 0;
			int dx = 0, dy = 0;
			String[][] map = new String[H][W];
			for (int i = 0; i < H; i++) {
				String input = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = input.charAt(j) + "";
					
					if (map[i][j].equals("^")) {
						x = i;
						y = j;
						dx = -1;
						dy = 0;
					}
					
					if (map[i][j].equals("v")) {
						x = i;
						y = j;
						dx = 1;
						dy = 0;
					}
					
					if (map[i][j].equals("<")) {
						x = i;
						y = j;
						dx = 0;
						dy = -1;
					}
					
					if (map[i][j].equals(">")) {
						x = i;
						y = j;
						dx = 0;
						dy = 1;
					}
				}
			}
			
			int N = sc.nextInt();
			String order = sc.next();
			for (int i = 0; i < N; i++) {
				if (order.charAt(i) == 'U') {
					dx = -1;
					dy = 0;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = "^";
				}
				
				if (order.charAt(i) == 'D') {
					dx = 1;
					dy = 0;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = "v";
				}
				
				if (order.charAt(i) == 'L') {
					dx = 0;
					dy = -1;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = "<";
				}

				if (order.charAt(i) == 'R') {
					dx = 0;
					dy = 1;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = ">";
				}
				
				if (order.charAt(i) == 'S') {
					int nx = x + dx;
					int ny = y + dy;
					while (true) {
						if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny].equals("#")) {
							break;
						}
						
						if (map[nx][ny].equals("*")) {
							map[nx][ny] = ".";
							break;
						}
						
						nx = nx + dx;
						ny = ny + dy;
					}
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
