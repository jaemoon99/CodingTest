import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	static int h, w, result = 0;
	static String[][] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		arr = new String[h][w];
		for (int i = 0; i < h; i++) {
			String line = sc.next();
			for (int j = 0; j < w; j++) {
				arr[i][j] = line.charAt(j) + "";
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j].equals("L")) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(result - 1);
		
		sc.close();
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		
		int[] start = {x, y};
		int[][] check = new int[h][w];
		
		q.add(start);
		check[x][y] = 1;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny].equals("L") && check[nx][ny] == 0) {
					q.add(new int[] {nx, ny});
					check[nx][ny] = check[poll[0]][poll[1]] + 1;
				}
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (check[i][j] > result) {
					result = check[i][j];
				}
			}
		}
		
	}

}
