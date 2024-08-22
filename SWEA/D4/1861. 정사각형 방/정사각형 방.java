import java.util.Scanner;

public class Solution {

	/**
	 * N : 한면 방 개수
	 * idx : 많이 이동할 수 있는 방번호
	 * result : 많이 이동할 수 있는 횟수
	 * map : 방 지도
	 * dx, dy : 상, 하, 좌, 우 탐색용 배열
	 */
	static int N;
	static int idx;
	static int result;
	static int[][] map;
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			// 지도 크기
			N = sc.nextInt();
			map = new int[N][N];
			// 방 번호 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 가장 작은 방번호
			idx = 999_999_999;
			// 이동할 수 있는 방 개수
			result = 0;
			// 지도 전체 순회
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 함수 호출
					func(i, j, 1, map[i][j]);
				}
			}
			// 정답 출력
			System.out.println("#" + tc + " " + idx + " " + result);
		}
	}
	
	static void func(int x, int y, int cnt, int sIdx) {
		// 이동할 수 있는지 판단
		boolean move = false;

		// 상, 하, 좌, 우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 좌표가 지도 안이면서 현재 좌표 + 1인 경우
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == map[x][y] + 1) {
                // 이동할 수 있다고 판단
            	move = true;
            	// 다음 좌표 호출
                func(nx, ny, cnt + 1, sIdx);
            }
        }

        // 움직일 수 없을 경우
        if (!move) {
        	// 움직인 횟수가 더 많을 경우
            if (cnt > result) {
            	// 갱신
                result = cnt;
                idx = sIdx;
            } 
            
            // 횟수가 같은데 방번호가 작은 경우
            if (cnt == result && sIdx < idx) {
            	// 갱신
                idx = sIdx;
            }
        }
	}
}
