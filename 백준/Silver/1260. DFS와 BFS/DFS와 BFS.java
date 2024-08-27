import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	/**
	 * n : 정점 개수
	 * sn : 정점 개수 + 1;
	 * graph : 그래프 현황
	 * visited : 방문 배열
	 * sb : 출력용 스트링빌더
	 */
	static int n;
	static int sn;
	static int[][] graph;
	static int[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		sn = n + 1;
		graph = new int[sn][sn];
		visited = new int[sn][sn];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			// 간선 양방향 표시
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		dfs(v);
		sb.append("\n");
		visited = new int[sn][sn];
		bfs(v);
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		sb.append(v + " ");
        // 출력한 노드 방문 표시(다른 노드로 부터 도착할 경우)
        for (int i = 1; i < sn; i++) {
            visited[i][v] = 1;
        }

        for (int end = 1; end < sn; end++) {
            // 서로 연결된 노드이면서 방문하지 않은 노드 탐색
            if (graph[v][end] == 1 && visited[v][end] == 0) {
                dfs(end);
            }
        }
	}
	
	static void bfs(int v) {
		Deque<Integer> queue = new ArrayDeque<>();
		
		queue.offer(v);
		
		while (!queue.isEmpty()) {
            int start = queue.poll();
            // 방문한 노드 출력
            sb.append(start + " ");

            // 출력한 노드 방문 표시(다른 노드로 부터 도착할 경우)
            for (int i = 1; i < sn; i++) {
                visited[i][start] = 1;
            }

            for (int end = 1; end < sn; end++) {
                // 서로 연결된 노드이면서 방문하지 않은 노드 탐색
                if (graph[start][end] == 1 && visited[start][end] == 0) {
                    // 큐에 없는 노드만 추가
                    if (!queue.contains(end)) {
                        queue.add(end);
                    }
                }
            }
        }
		sb.append("\n");
	}
}
