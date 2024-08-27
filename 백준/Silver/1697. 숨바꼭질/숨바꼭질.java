import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(bfs(n, k));
	}
	
	static int bfs(int N, int K) {
        int maxPosition = 100000;
        int[] visited = new int[maxPosition + 1];  // 방문한 위치의 시간 저장
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // 동생의 위치에 도달했을 때 걸린 시간 반환
            if (current == K) {
                return visited[current];
            }
            
            // 가능한 다음 위치 탐색 (current - 1, current + 1, current * 2)
            int[] nextPositions = {current - 1, current + 1, current * 2};
            
            for (int next : nextPositions) {
                if (next >= 0 && next <= maxPosition && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }
        
        return -1; // 도달할 수 없는 경우
	}
}
