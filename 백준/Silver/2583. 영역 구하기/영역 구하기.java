import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static ArrayList<Integer> resList = new ArrayList<>();
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        int K = sc.nextInt();
        
        map = new int[N][M];
        
        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            for (int j = y1; j <= y2 - 1; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
            
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                bfs(i, j);
            }
        }
        
        Collections.sort(resList);
        StringBuilder sb = new StringBuilder();
        sb.append(resList.size() + "\n");
        for (int res : resList) {
            sb.append(res + " ");
        }
        
        System.out.println(sb);
    }
    
    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        map[x][y] = 1;
        
        int cnt = 1;
        while (!queue.isEmpty()) {
            
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) {
                    continue;
                }
                
                map[nx][ny] = 1;
                cnt++;
                queue.offer(new int[] {nx, ny});
            }
        }
        resList.add(cnt);
    }
}