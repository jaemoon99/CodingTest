import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	static int m, n, result = 0;
	static int[][] arr;
	static int[][] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();

		arr = new int[m][n];
		check = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1 && check[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

		System.out.println(result);

		sc.close();
	}

	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<int[]>();

		int[] start = {x, y};

		q.add(start);

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			check[poll[0]][poll[1]] = 1;

			for (int i = 0; i < 8; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == 1 && check[nx][ny] == 0) {
					q.add(new int[] {nx, ny});
					check[nx][ny] = 1;
				}

			}
		}
		result += 1;
	}
}