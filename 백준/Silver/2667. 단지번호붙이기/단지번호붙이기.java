import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][] apartMap;
    private static int[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static ArrayList<Integer> apartCount = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        apartMap = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                apartMap[i][j] = input.charAt(j) - '0';
            }
        }

        int complexCnt = 0;
        for (int i = 0; i < apartMap.length; i++) {
            for (int j = 0; j < apartMap.length; j++) {
                if (apartMap[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    apartCount.add(bfs(i, j)) ;
                    complexCnt++;
                }
            }
        }

        System.out.println(complexCnt);
        Collections.sort(apartCount);
        for (Integer apart : apartCount) {
            System.out.println(apart);
        }
    }

    public static int bfs(int i, int j) {
        int apartCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] start = queue.poll();
            apartCount++;
            int x = start[0], y = start[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || apartMap[nx][ny] == 0 || visited[nx][ny] == 1) {
                    continue;
                }

                visited[nx][ny] = 1;
                queue.add(new int[]{nx, ny});
            }
        }
        return apartCount;
    }
}