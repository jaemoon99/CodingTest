import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	static int n, map[][], visited[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n + 1][n + 1];
		visited = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (visited[i] == 0) {
				bfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
	
	static void bfs(int node) {
		Deque<Integer> q = new ArrayDeque<>();
		
		q.offer(node);
		visited[node] = 1;
		
		while (!q.isEmpty()) {
			int poll = q.poll();
			
			for (int i = 1; i <= n; i++) {
				if (map[poll][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					q.offer(i);
				}
			}
		}
	}
}
