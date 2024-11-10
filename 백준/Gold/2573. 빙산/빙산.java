import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    
    static int n, m;
    static int[][] map, visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        map = new int[n][m];
        visited = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        int result = 0;
        
        while (true) {
            // 매번 덩어리가 몇 개가 있는지 체크
            int icebergCount = 0;
            visited = new int[n][m]; // 매번 visited 배열 초기화
            
            // 빙산 녹이기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0 && visited[i][j] == 0) {
                        icebergCount++;
                        bfs(i, j, icebergCount);
                    }
                }
            }
            
            // 빙산 덩어리가 두 개 이상이면 종료
            if (icebergCount >= 2) {
                System.out.println(result);
                break;
            }
            
            // 얼음이 모두 녹았을 경우
            boolean allMelted = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0) {
                        allMelted = false;
                        break;
                    }
                }
            }
            if (allMelted) {
                System.out.println(0);
                break;
            }
            
            // 얼음 녹이기
            melt();
            
            result++;
        }
    }
    
    // BFS로 빙산 덩어리 찾아 방문 처리
    static void bfs(int x, int y, int gId) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[x][y] = gId;
        queue.offer(new int[] {x, y});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] > 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = gId;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
    
    // 빙산을 녹이기
    static void melt() {
        int[][] newMap = new int[n][m];
        
        // 각 칸에 대해 주변 바다의 수를 세고, 얼음을 녹임
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int seaCount = 0;
                    // 상하좌우 확인
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                            seaCount++;
                        }
                    }
                    // 녹는 양 만큼 줄임
                    newMap[i][j] = Math.max(0, map[i][j] - seaCount);
                }
            }
        }
        
        // 녹은 얼음을 새로운 맵에 반영
        map = newMap;
    }
}
