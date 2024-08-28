import java.util.*;

public class Main {

	/**
	 * map : 사람 배열
	 * v : 방문 체크용 배열
	 */
    static ArrayList<Integer>[] map;
    static boolean[] v;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 사람 수
        int n = sc.nextInt();
        
        map = new ArrayList[n + 1];
        v = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        
        // 촌 연결
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            map[num1].add(num2);
            map[num2].add(num1);
        }

        // 탐색
        int result = bfs(p1, p2);
        // 결과 출력
        System.out.println(result);
    }
    
    static int bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        // 방문 표시
        v[start] = true;
        
        // 큐가 빌 때까지 탐색
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            
            // 타겟과 통일한 경우
            if (x == target) {
                return y;
            }
            
            // 본인과 연결된 사람 순회
            for (int p : map[x]) {
            	// 방문하지 않은 경우
                if (!v[p]) {
                	// 방문 표시
                    v[p] = true;
                    // 다음 사람 삽입
                    queue.add(new int[]{p, y + 1});
                }
            }
        }
        
        return -1;
    }
}