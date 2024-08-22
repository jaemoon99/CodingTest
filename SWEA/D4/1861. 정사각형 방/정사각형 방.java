import java.util.Scanner;

public class Solution {

	static int N;
	static int idx;
	static int result;
	static int[][] map;
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			idx = 999_999_999;
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					func(i, j, 1, map[i][j]);
				}
			}
			System.out.println("#" + tc + " " + idx + " " + result);
		}
	}
	
	static void func(int x, int y, int cnt, int sIdx) {
		
		boolean canMove = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == map[x][y] + 1) {
                canMove = true;
                func(nx, ny, cnt + 1, sIdx);
            }
        }

        if (!canMove) {
            if (cnt > result) {
                result = cnt;
                idx = sIdx;
            } else if (cnt == result && sIdx < idx) {
                idx = sIdx;
            }
        }
	}
}
