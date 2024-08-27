import java.util.Scanner;

public class Solution {

    static int N;
    static int[][] map;
    static boolean[] visited; // 디저트를 먹었는지 확인하는 배열
    static int maxDesserts; // 먹을 수 있는 디저트의 최대 개수

    // 방향을 나타내는 배열 (우하, 좌하, 좌상, 우상 순서)
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[101]; // 디저트 종류는 1~100번

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            maxDesserts = -1; // 최대 디저트 개수 초기화

            // 모든 점에서 출발해보며 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited[map[i][j]] = true; // 시작점 방문 체크
                    dfs(i, j, i, j, 0, 0); // 초기 방향 dIndex = 0, 먹은 개수 count = 0
                    visited[map[i][j]] = false; // 백트래킹
                }
            }

            // 결과 출력
            System.out.println("#" + tc + " " + maxDesserts);
        }

        sc.close();
    }

    // DFS 탐색을 통한 백트래킹
    static void dfs(int startX, int startY, int x, int y, int count, int dIndex) {
        // 네 방향을 탐색 (대각선 방향)
        for (int d = dIndex; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 다음 좌표가 유효한 범위 내에 있는지 확인
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 출발점으로 되돌아왔고, 최소 3개의 변을 지난 경우
                if (nx == startX && ny == startY && count >= 3) {
                    maxDesserts = Math.max(maxDesserts, count + 1); // 최대 디저트 개수 갱신
                    return;
                }

                // 아직 방문하지 않은 디저트 종류라면
                if (!visited[map[nx][ny]]) {
                    visited[map[nx][ny]] = true; // 방문 표시
                    dfs(startX, startY, nx, ny, count + 1, d); // 다음 지점으로 이동
                    visited[map[nx][ny]] = false; // 백트래킹 - 방문 해제
                }
            }
        }
    }
}