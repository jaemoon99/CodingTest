import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int v, visited[];
	static List<Integer>[] map;
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			v = sc.nextInt();
			int e = sc.nextInt();
			
			map = new ArrayList[v + 1];
			visited = new int[v + 1];
			
			for (int j = 1; j <= v; j++) {
				map[j] = new ArrayList<>();
			}
			
			for (int j = 0; j < e; j++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				map[v1].add(v2);
				map[v2].add(v1);
			}
			
			String result = "YES";
			for (int j = 1; j <= v; j++) {
				if (visited[j] == 0) {
					if (!bfs(j)) {
						result = "NO";
						break;
					}
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
	
	static boolean bfs(int n) {
		Deque<Integer> queue = new ArrayDeque<>();
		
		visited[n] = 1;
		queue.offer(n);

		while (!queue.isEmpty()) {
			int poll = queue.poll();
			
			for (int next : map[poll]) {
				if (visited[next] == 0) {
					visited[next] = 0 - visited[poll];
					queue.offer(next);
				} else if (visited[poll] == visited[next]) {
					return false;
				}
			}
		}
		
		return true;
	}
}