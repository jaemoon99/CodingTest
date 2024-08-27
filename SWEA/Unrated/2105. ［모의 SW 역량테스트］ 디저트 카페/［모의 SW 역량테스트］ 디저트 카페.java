import java.util.Scanner;

public class Solution {

	/**
	 * N : 지역 한 변의 길이
	 * map : 가게 지도
	 * v : 방문 체크용 배열
	 * max : 최대 디저트 개수
	 * dx, dy : 4방 탐색용 배열
	 */
    static int n;
    static int[][] map;
    static boolean[] v;
    static int max;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수
        int T = sc.nextInt();

        for (int tc = 1; tc < T + 1; tc++) {
            n = sc.nextInt();
            map = new int[n][n];
            // 디저트 종류는 1~100번
            v = new boolean[101];

            // 지도 입력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            // 최대 디저트 개수 초기화
            max = -1; 

            // 전체 순회
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                	// 시작점 방문 체크
                    v[map[i][j]] = true;
                    dfs(i, j, i, j, 0, 0);
                    // 백트래킹
                    v[map[i][j]] = false;
                }
            }

            // 결과 출력
            System.out.println("#" + tc + " " + max);
        }
    }

    static void dfs(int startX, int startY, int x, int y, int count, int dIndex) {
        // 4방 탐색
        for (int d = dIndex; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 지도 내에 있는 경우
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                // 출발점으로 되돌아왔고 최소 3개의 변을 지난 경우
                if (nx == startX && ny == startY && count >= 3) {
                	// 최대 디저트 개수 갱신
                	if (count + 1 > max) {
                		max = count + 1;
                	}
                    return;
                }

                // 아직 방문하지 않은 디저트 종류라면
                if (!v[map[nx][ny]]) {
                	// 방문 표시
                    v[map[nx][ny]] = true;
                    // 다음 지점으로 이동
                    dfs(startX, startY, nx, ny, count + 1, d);
                    // 백트래킹
                    v[map[nx][ny]] = false;
                }
            }
        }
    }
}