import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	static int n, v1[][], v2[][];
	static String map[][];
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new String[n][n];
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) + "";
			}
		}
		int gId1 = 0;
		int gId2 = 0;
		v1 = new int[n][n];
		v2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (v1[i][j] == 0) {					
					bfs1(i, j, ++gId1);
				}
				
				if (v2[i][j] == 0) {
					bfs2(i, j, ++gId2);
				}
			}
		}		
		System.out.println(gId1 + " " + gId2);
	}
	
	static void bfs1(int x, int y, int gId) {
		Deque<int[]> queue = new ArrayDeque<>();
		
		v1[x][y] = gId;
		queue.offer(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if (n > nx && nx >= 0 && n > ny && ny >= 0 && v1[nx][ny] == 0) {
					if (map[poll[0]][poll[1]].equals(map[nx][ny])) {
						v1[nx][ny] = gId;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	static void bfs2(int x, int y, int gId) {
		Deque<int[]> queue = new ArrayDeque<>();
		
		v2[x][y] = gId;
		queue.offer(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if (n > nx && nx >= 0 && n > ny && ny >= 0 && v2[nx][ny] == 0) {
					if (map[poll[0]][poll[1]].equals("R") || map[poll[0]][poll[1]].equals("G")) {
						if (map[nx][ny].equals("R") || map[nx][ny].equals("G")) {
							v2[nx][ny] = gId;
							queue.add(new int[] {nx, ny});
						}
					} else {
						if (map[poll[0]][poll[1]].equals(map[nx][ny])) {
							v2[nx][ny] = gId;
							queue.add(new int[] {nx, ny});
						}
					}
				}
			}
		}
	}
}