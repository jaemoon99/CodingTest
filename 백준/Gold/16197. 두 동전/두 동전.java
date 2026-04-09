import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static class Location {
        int x1, y1, x2, y2, cnt;

        Location(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }

    static int n, m;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        int[] coin1 = null;
        int[] coin2 = null;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'o') {
                    if (coin1 == null) {
                        coin1 = new int[]{i, j};
                    } else {
                        coin2 = new int[]{i, j};
                    }
                }
            }
        }

        System.out.println(bfs(coin1, coin2));
    }

    private static int bfs(int[] coin1, int[] coin2) {
        Deque<Location> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        q.add(new Location(coin1[0], coin1[1], coin2[0], coin2[1], 0));
        visited[coin1[0]][coin1[1]][coin2[0]][coin2[1]] = true;

        while (!q.isEmpty()) {
            Location cur = q.poll();

            if (cur.cnt >= 10) continue;

            for (int d = 0; d < 4; d++) {
                int nx1 = cur.x1 + dx[d];
                int ny1 = cur.y1 + dy[d];
                int nx2 = cur.x2 + dx[d];
                int ny2 = cur.y2 + dy[d];

                boolean out1 = isOut(nx1, ny1);
                boolean out2 = isOut(nx2, ny2);

                if (out1 && out2) continue;
                if (out1 || out2) {
                    return cur.cnt + 1;
                }

                if (board[nx1][ny1] == '#') {
                    nx1 = cur.x1;
                    ny1 = cur.y1;
                }
                if (board[nx2][ny2] == '#') {
                    nx2 = cur.x2;
                    ny2 = cur.y2;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.add(new Location(nx1, ny1, nx2, ny2, cur.cnt + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}