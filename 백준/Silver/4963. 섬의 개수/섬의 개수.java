import java.io.*;
import java.util.*;

public class Main {

    /**
     * w : 가로
     * h : 세로
     * islandMap : 섬 위치 배열
     * visited : 인접 체크 배열
     * dx, dy : 상, 하, 좌, 우, 대각선 배열
     */
    static int w;
    static int h;
    static int[][] islandMap;
    static int[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 가로, 세로 입력
            w = sc.nextInt();
            h = sc.nextInt();

            // 입력 값이 0, 0일 경우 종료
            if (w == 0 && h == 0) {
                break;
            }

            // 배열 선언
            islandMap = new int[h][w];
            visited = new int[h][w];

            // 섬 위치 입력
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    islandMap[i][j] = sc.nextInt();
                }
            }

            // 섬 개수
            int cnt = 0;

            // 배열 전체 순회
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 현재 위치 값이 섬이고 방문하지 않은 경우
                    if (islandMap[i][j] == 1 && visited[i][j] == 0) {
                        // 방문표시
                        visited[i][j] = 1;
                        // 인접 섬 체크
                        bfs(new int[]{i, j});
                        // 섬 카운트
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();
        // 큐에 섬 담기
        queue.add(start);

        // 큐에 원소가 없을 때까지
        while (!queue.isEmpty()) {
            // 맨 앞 원소 꺼냄
            int[] element = queue.poll();

            // 각각 가로 세로 죄표 할당
            int x = element[0];
            int y = element[1];

            // 상, 하, 좌, 우, 대각선 체크
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 좌표가 배열 내의 좌표인 경우
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    // 좌표가 섬이고 방문하지 않은 경우
                    if (islandMap[nx][ny] == 1 && visited[nx][ny] == 0) {
                        // 방문 표시
                        visited[nx][ny] = 1;
                        // 큐에 삽입
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}