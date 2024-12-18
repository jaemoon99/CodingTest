import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	static int n, m, map[][][];
	static int[] dx = new int[] {1, 0, 1};
	static int[] dy = new int[] {0, 1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m][2];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j][0] = sc.nextInt();
				map[i][j][1] = Integer.MIN_VALUE;
			}
		}
		
		bfs(0, 0);
		
		System.out.println(map[n - 1][m - 1][1]);
		sc.close();
	}
	
	static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x, y});
		map[x][y][1] = map[x][y][0];
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			x = poll[0];
			y = poll[1];
			
			for (int i = 0; i < 3; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				
				if (n > nx && nx >= 0 && m > ny && ny >= 0) {
					int sum = map[x][y][1] + map[nx][ny][0];
					
					if (sum > map[nx][ny][1]) {
						map[nx][ny][1] = sum;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
