import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	/**
	 * n : 맵크기
	 * map : 코어 지도
	 * cores : 코어 좌표 배열
	 * result : 결과값
	 * maxCores : 연결된 최대 코어 개수
	 * totalCores : 총 코어 개수
	 * dx, dy : 4방 탐색용 배열
	 */
    static int n;
    static int[][] map;
    static ArrayList<int[]> cores;
    static int result;
    static int maxCores;
    static int totalCores;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 수
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            map = new int[n][n];
            cores = new ArrayList<>();

            // 회로판 입력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                    // 가장자리가 아닌 코어만 리스트에 추가
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != n - 1 && j != n - 1) {
                        cores.add(new int[]{i, j});
                    }
                }
            }

            totalCores = cores.size();
            // 최소값을 구해야하기 때문에 큰 수로 초기화
            result = 999_999_999;
            maxCores = 0;

            dfs(0, 0, 0);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int cnt, int cCores, int totalLen) {
        // 모든 코어를 처리한 경우
        if (cnt == totalCores) {
            // 더 많은 코어를 연결했거나, 같은 수의 코어를 연결하면서 전선 길이가 짧은 경우 갱신
            if (cCores > maxCores || 
                (cCores == maxCores && totalLen < result)) {
                maxCores = cCores;
                result = totalLen;
            }
            return;
        }

        int[] core = cores.get(cnt);
        int x = core[0], y = core[1];

        // 4방향으로 시도
        for (int d = 0; d < 4; d++) {
        	// 전선을 연결할 수 있는지 확인
            int len = canConnect(x, y, d);
            // 연결 가능한 경우
            if (len > 0) {
            	// 표시
                edit(x, y, d, 2);
                // 다음 코어로 이동
                dfs(cnt + 1, cCores + 1, totalLen + len);
                // 다시 제거
                edit(x, y, d, 0);
            }
        }

        // 연결하지 않고 다음 코어로 이동
        dfs(cnt + 1, cCores, totalLen);
    }

    private static int canConnect(int x, int y, int d) {
        int nx = x, ny = y;
        int len = 0;

        while (true) {
            nx += dx[d];
            ny += dy[d];

            // 경계를 벗어난 경우
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            	break;
            }

            // 다른 코어나 전선이 있는 경우
            if (map[nx][ny] != 0) {
            	return -1;
            }

            len++;
        }

        return len; // 연결 가능한 경우 전선 길이 반환
    }

    private static void edit(int x, int y, int d, int v) {
        int nx = x, ny = y;

        while (true) {
            nx += dx[d];
            ny += dy[d];

            // 경계를 벗어나면 종료
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            	break;
            }

            map[nx][ny] = v; // 전선을 놓거나 제거
        }
    }
}