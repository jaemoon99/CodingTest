import java.util.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static int[][] temp;
    private static int[][] visited;
    private static int[] dx = new int[] {-1, 1, 0, 0};
    private static int[] dy = new int[] {0, 0, -1, 1};
    private static int cnt = 0;
    private static int result = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]  + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//

        for (int i = 0; i <= max; i++) {
            cnt = 0;

            temp = Arrays.copyOf(map, map.length);
            visited = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i >= temp[j][k]) {
                        temp[j][k] = 0;
                        visited[j][k] = 1;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    if (temp[k][j] != 0 && visited[k][j] == 0) {
                        bfs(k, j);
                    }
                }
            }

            if (cnt > result) {
                result = cnt;
            }
        }
        System.out.println(result);
    }

    private static void bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && temp[nx][ny] != 0 && visited[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
        cnt++;
    }
}
