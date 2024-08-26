import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	/**
	 * h : 맵 세로
	 * w : 맵 가로
	 * cnt : 치즈 개수
	 * map : 치즈 지도 배열
	 * dx, dy : 상, 하, 좌, 우 탐색용 배열
	 */
	static int h;
	static int w;
	static int cnt;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();
		w = sc.nextInt();
		
		cnt = 0;
		// 치즈 입력
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = sc.nextInt();
				
				// 1인 경우 치즈 개수 증가
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		// 결과값
		int result = 0;
		// 다 녹기 직전 치즈 개수
		int lastCheeseCount = cnt;
		// 치즈가 다 녹을 때까지 반복
		while (cnt != 0) {		
			// 치즈 개수 갱신
			lastCheeseCount = cnt;
			// 탐색
			bfs(0, 0);
			// 치즈 녹이기
			reset();
			// 시간 증가
			result++;
		}
		// 정답 출력
		System.out.println(result + " " + lastCheeseCount);
	}
	
	static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		// 방문 표시
		map[x][y] = -1;
		
		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			// 상, 하, 좌, 우 탐색
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				// 맵 밖인 경우 무시
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
					continue;
				}
				
				// 공기와 인접한 치즈인 경우
				if (map[nx][ny] == 1) {
					// 녹는 표시
					map[nx][ny] = -1;
					// 치즈 개수 감소
					cnt--;
				}
				
				// 공기인 경우
				if (map[nx][ny] == 0) {
					// 큐에 담기
					queue.offer(new int[] {nx, ny});
					// 방문 표시
					map[nx][ny] = -1;
				}
			}
		}
	}
	
	static void reset() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				// 공기이거나 녹은 치즈인 경우
				if (map[i][j] == -1) {
					// 공기 처리
					map[i][j] = 0;
				}
			}
		}
	}
}
