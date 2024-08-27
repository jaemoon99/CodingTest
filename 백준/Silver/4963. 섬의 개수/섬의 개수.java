import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    static int w;
    static int h;
    static int map[][];
    static int visited[][];
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == 0) {
                        bfs(i, j);
                        // dfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = 1;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] == 1 || map[nx][ny] == 0) {
                continue;
            }

            dfs(nx, ny);
        }
    }

    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] == 1 || map[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}