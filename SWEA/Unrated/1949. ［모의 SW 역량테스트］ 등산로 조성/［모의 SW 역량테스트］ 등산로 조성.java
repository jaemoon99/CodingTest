import java.util.Scanner;

public class Solution {
    static int N, K, result;
    static int[][] map;
    static boolean[][] v;
    // 4방탐색
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 지도의 크기
            K = sc.nextInt(); // 최대 깎을 수 있는 깊이
            map = new int[N][N];
            v = new boolean[N][N];
            result = 0;

            int h = 0; // 가장 높은 지형의 높이

            // 지도 데이터 입력 및 가장 높은 지형 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] > h) {
                        h = map[i][j];
                    }
                }
            }

            // 가장 높은 지형에서 등산로 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == h) {
                        dfs(i, j, 1, false); // (i, j)에서 길이 1, 깎지 않음으로 DFS 시작
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int x, int y, int len, boolean cut) {
        // 최대 길이 갱신
        if (len > result) {
            result = len;
        }

        v[x][y] = true; // 현재 위치 방문 처리

        // 4방향 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !v[nx][ny]) { // 지도 안에 있고 방문하지 않은 경우
                if (map[nx][ny] < map[x][y]) { // 다음 위치가 현재보다 낮은 경우
                    dfs(nx, ny, len + 1, cut);
                } else if (!cut && map[nx][ny] - K < map[x][y]) { // 깎지 않았고, 깎아서 이동할 수 있는 경우
                    int originalHeight = map[nx][ny];
                    map[nx][ny] = map[x][y] - 1; // 지형 깎기
                    dfs(nx, ny, len + 1, true); // 깎았음을 표시하고 DFS 진행
                    map[nx][ny] = originalHeight; // 원상 복구
                }
            }
        }

        v[x][y] = false; // 백트래킹을 위해 방문 표시 제거
    }
}