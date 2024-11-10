import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int n, l, r, map[][], v[][];
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int result = -1;
		int check = 1;
		while (true) {
			if (check == 0) {
				break;
			}
			
			int cnt = 0;
			int gId = 1;
			v = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (n > nx && nx >= 0 && n > ny && ny >= 0 && v[i][j] == 0 && v[nx][ny] == 0) {
							int sub = Math.abs(map[i][j] - map[nx][ny]);
							if (r >= sub && sub >= l) {
								bfs(i, j, gId++);
								cnt++;
							}
						}
					}
				}
			}
			
			result++;
			
			if (cnt == 0) {
				check = 0;
			}
		}
		
		System.out.println(result);
	}
	
	static void bfs(int x, int y, int gId) {
		Deque<int[]> queue = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		
		v[x][y] = gId;
		queue.offer(new int[] {x, y});
		
		int sum = 0;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			list.add(poll);
			sum += map[poll[0]][poll[1]];
			
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if (n > nx && nx >= 0 && n > ny && ny >= 0 && v[nx][ny] == 0) {
					int sub = Math.abs(map[poll[0]][poll[1]] - map[nx][ny]);
					if (r >= sub && sub >= l) {
						v[nx][ny] = gId;
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
		int div = sum / list.size();
		for (int[] arr : list) {
			map[arr[0]][arr[1]] = div;
		}
	}
}
