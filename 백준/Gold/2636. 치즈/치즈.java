import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	static int h;
	static int w;
	static int cnt;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		cnt = 0;
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = sc.nextInt();
				
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		int result = 0;
		int lastCheeseCount = cnt;
		while (cnt != 0) {			
			lastCheeseCount = cnt;
			bfs(0, 0);
			reset();
			result++;
		}
		System.out.println(result + " " + lastCheeseCount);
	}
	
	static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		map[x][y] = -1;
		
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
					continue;
				}
				
				if (map[nx][ny] == 1) {
					map[nx][ny] = -1;
					cnt--;
				}
				
				if (map[nx][ny] == 0) {
					queue.offer(new int[] {nx, ny});
					map[nx][ny] = -1;
				}
			}
		}
	}
	
	static void reset() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == -1) {
					map[i][j] = 0;
				}
			}
		}
	}
}
