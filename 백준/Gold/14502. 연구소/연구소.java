import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int n, m, map[][], visited[][], listVisited[], result = Integer.MIN_VALUE;
	static List<int[]> list;
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		
		// 빈공간 찾기
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		listVisited = new int[list.size()];
		
		// 조합
		combination(0, 0);

		System.out.println(result);
	}
	
	static void bfs(int x, int y, int[][] newMap) {
		Deque<int[]> q = new ArrayDeque<>();

		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if (n > nx && nx >= 0 && m > ny && ny >= 0 && newMap[nx][ny] == 0 && visited[nx][ny] == 0) {
					visited[nx][ny] = 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	static void combination(int idx, int cnt) {
		if (cnt == 3) {
			List<int[]> sel = new ArrayList<>();
			for (int i = 0; i < listVisited.length; i++) {
				if (listVisited[i] == 1) {
					sel.add(list.get(i));
				}
			}
			
			int[][] newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, newMap[i], 0, m);
            }
			visited = new int[n][m];
			for (int i = 0; i < 3; i++) {
				newMap[sel.get(i)[0]][sel.get(i)[1]] = 1;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (newMap[i][j] == 2 && visited[i][j] == 0) {
						bfs(i, j, newMap);
					}
				}
			}
			
			int saveCnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (newMap[i][j] == 0 && visited[i][j] == 0) {
						saveCnt++;
					}
				}
			}
			
			if (saveCnt > result) {
				result = saveCnt;
			}
			return;
		}
		
		for (int i = idx; i < listVisited.length; i++) {
			if (listVisited[i] == 0) {
				listVisited[i] = 1;
				combination(i, cnt + 1);
				listVisited[i] = 0;
			}
		}
		
	}
}
