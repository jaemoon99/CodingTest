import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int v, visited[];
	static List<Integer>[] map;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			v = sc.nextInt();
			int e = sc.nextInt();
			
			// 그래프 초기화
			map = new ArrayList[v + 1];
			visited = new int[v + 1]; // 0은 방문 안함, 1은 그룹 1, -1은 그룹 2
			
			for (int j = 1; j <= v; j++) {
				map[j] = new ArrayList<>();
			}
			
			// 간선 입력
			for (int j = 0; j < e; j++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				map[v1].add(v2);
				map[v2].add(v1);
			}
			
			// 이분 그래프 체크
			String result = "YES";
			for (int j = 1; j <= v; j++) {
				if (visited[j] == 0) {  // 방문하지 않은 노드만 BFS 수행
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
	
	// BFS 함수: 이분 그래프 판별
	static boolean bfs(int start) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = 1; // 첫 번째 노드는 그룹 1

		while (!queue.isEmpty()) {
			int poll = queue.poll();

			// 현재 정점의 인접 정점들을 확인
			for (int next : map[poll]) {
				if (visited[next] == 0) {
					// 아직 방문하지 않았다면, 반대 그룹으로 방문
					visited[next] = -visited[poll];
					queue.offer(next);
				} else if (visited[next] == visited[poll]) {
					// 이미 방문했는데 그룹이 같다면 이분 그래프가 아님
					return false;
				}
			}
		}
		return true;  // 이분 그래프가 맞다면 true 반환
	}
}
