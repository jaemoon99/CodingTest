import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 수
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			// 지도 세로
			int H = sc.nextInt();
			// 지도 가로
			int W = sc.nextInt();
			
			// 탱크 좌표
			int x = 0, y = 0;
			// 방향 좌표
			int dx = 0, dy = 0;
			
			String[][] map = new String[H][W];
			// 지도 입력
			for (int i = 0; i < H; i++) {
				String input = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = input.charAt(j) + "";
					
					// 탱크 좌표 확인 상, 하, 좌, 우 각각 경우의 수에 따라 탱크, 방향 좌표 설정
					if (map[i][j].equals("^")) {
						x = i;
						y = j;
						dx = -1;
						dy = 0;
					}
					
					if (map[i][j].equals("v")) {
						x = i;
						y = j;
						dx = 1;
						dy = 0;
					}
					
					if (map[i][j].equals("<")) {
						x = i;
						y = j;
						dx = 0;
						dy = -1;
					}
					
					if (map[i][j].equals(">")) {
						x = i;
						y = j;
						dx = 0;
						dy = 1;
					}
				}
			}
			
			// 입력 개수
			int N = sc.nextInt();
			String order = sc.next();
			for (int i = 0; i < N; i++) {
				// U, D, L, R 각각에 따라 방향좌표를 설정 후 탱크좌표와 계산한 후 계산한 좌표가 지도 내에 있고 이동가능한 경우 위치 갱신
				if (order.charAt(i) == 'U') {
					dx = -1;
					dy = 0;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = "^";
				}
				
				if (order.charAt(i) == 'D') {
					dx = 1;
					dy = 0;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = "v";
				}
				
				if (order.charAt(i) == 'L') {
					dx = 0;
					dy = -1;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = "<";
				}

				if (order.charAt(i) == 'R') {
					dx = 0;
					dy = 1;
					int nx = x + dx;
					int ny = y + dy;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
						map[x][y] = ".";
						x = nx;
						y = ny;
					}
					map[x][y] = ">";
				}
				
				// S의 경우 현재 방향에 따라 지도 끝 또는 벽을 만날 때까지 순회
				if (order.charAt(i) == 'S') {
					int nx = x + dx;
					int ny = y + dy;
					while (true) {
						// 지도 밖이거나 강철 벽인 경우
						if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny].equals("#")) {
							break;
						}
						
						// 벽돌 벽인 경우 파괴 후 종료
						if (map[nx][ny].equals("*")) {
							map[nx][ny] = ".";
							break;
						}
						
						// 다음 좌표값 설정
						nx = nx + dx;
						ny = ny + dy;
					}
				}
			}
			
			// 정답 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
