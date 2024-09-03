import java.util.Scanner;

public class Main {
	
    static int N;  // 도시의 수
    static int[][] map;  // 비용 행렬
    static boolean[] v;  // 방문 여부 체크
    static int result = Integer.MAX_VALUE;  // 최소 비용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 도시의 수
        map = new int[N][N];
        v = new boolean[N];

        // 비용 행렬 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 모든 도시를 시작점으로 하여 탐색 시작
        for (int i = 0; i < N; i++) {
            v[i] = true;
            dfs(i, i, 1, 0);
            v[i] = false;
        }

        // 최소 비용 출력
        System.out.println(result);
    }
    
    public static void dfs(int start, int cur, int cnt, int totalCost) {
        // 모든 도시를 방문하고 시작점으로 돌아온 경우
        if (cnt == N && map[cur][start] != 0) {
            result = Math.min(result, totalCost + map[cur][start]);
            return;
        }

        // 백트래킹을 이용해 모든 경로를 탐색
        for (int i = 0; i < N; i++) {
            if (!v[i] && map[cur][i] != 0) {
                v[i] = true;
                dfs(start, i, cnt + 1, totalCost + map[cur][i]);
                v[i] = false;
            }
        }
    }
}