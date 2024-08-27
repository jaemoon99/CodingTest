import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	/**
	 * w : 지도 너비
	 * h : 지도 높이
	 * map : 지도
	 * dx, dy : 8방 탐색용 배열
	 */
    static int w;
    static int h;
    static int map[][];
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            // 높이, 너비가 둘 다 0이면 종료
            if (w == 0 && h == 0) {
                break;
            }

            // 섬 입력
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                	// 섬인경우 함수 호출
                    if (map[i][j] == 1) {
                    	dfs(i, j);
//                        bfs(i, j);
                        result++;
                    }
                }
            }
            
            // 결과 출력
            System.out.println(result);
        }
    }

    static void dfs(int x, int y) {
    	// 방문 표시
    	map[x][y] = 0;

    	// 8방 순회
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 밖이거나 섬이 아닌 경우 무시
            if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0) {
                continue;
            }

            // 다음 섬 호출
            dfs(nx, ny);
        }
    }

    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        // 방문 표시
        map[x][y] = 0;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            // 8방 순회
            for (int i = 0; i < 8; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                // 지도 밖이거나 섬이 아닌 경우 무시
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0) {
                    continue;
                }

                // 방문 표시
                map[nx][ny] = 0;
                // 인접 섬 큐에 삽입
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}