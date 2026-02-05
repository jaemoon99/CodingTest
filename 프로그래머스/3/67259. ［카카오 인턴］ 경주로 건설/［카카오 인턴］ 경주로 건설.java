import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private static final int INF = 999_999_999;

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dist = new int[n][n][4]; // 0:상, 1:우, 2:하, 3:좌

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) dist[i][j][d] = INF;
            }
        }

        // 시작점은 방향이 정해져있지 않으니 4방향 모두 0으로 시작 처리
        for (int d = 0; d < 4; d++) dist[0][0][d] = 0;

        return bfs(board, dist);
    }

    private int bfs(int[][] board, int[][][] dist) {
        int n = board.length;

        // 상, 우, 하, 좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Deque<int[]> dq = new ArrayDeque<>();
        // 시작점에서 "다음 이동"을 만들기 위해 4방향 상태를 모두 큐에 넣어둠 (비용 0)
        for (int d = 0; d < 4; d++) dq.add(new int[]{0, 0, d});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0], y = cur[1], dir = cur[2];

            int curCost = dist[x][y][dir];

            for (int nd = 0; nd < 4; nd++) {
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;

                int add = (dir == nd) ? 100 : 600; // 직진 100, 코너(방향전환) 600
                int nextCost = curCost + add;

                if (nextCost < dist[nx][ny][nd]) {
                    dist[nx][ny][nd] = nextCost;
                    dq.add(new int[]{nx, ny, nd});
                }
            }
        }

        int ans = INF;
        for (int d = 0; d < 4; d++) ans = Math.min(ans, dist[n - 1][n - 1][d]);
        return ans;
    }
}