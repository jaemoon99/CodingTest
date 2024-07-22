import java.io.*;
import java.util.*;

public class Main {

    private static int m;
    private static int n;
    private static int[][] tomatoMap;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        tomatoMap = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomatoMap[i][j] = sc.nextInt();
                if (tomatoMap[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int days = bfs(queue);

        boolean result = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoMap[i][j] == 0) {
                    result = false;
                }
            }
        }

        if (result) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }

    }

    public static int bfs(Queue<int[]> queue) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] start = queue.poll();
                int x = start[0];
                int y = start[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && tomatoMap[nx][ny] == 0) {
                        tomatoMap[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            days++;
        }

        return days;
    }
}
