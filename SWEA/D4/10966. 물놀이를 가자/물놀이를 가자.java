import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

    static int n, m, d[][];
    static String map[][];
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {            
            n = sc.nextInt();
            m = sc.nextInt();
            
            map = new String[n][m];
            d = new int[n][m];
            
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                String input = sc.next();
                for (int j = 0; j < input.length(); j++) {
                    map[i][j] = input.charAt(j) + "";
                    if (map[i][j].equals("W")) {
                        q.offer(new int[] {i, j});
                        d[i][j] = 0;
                    } else {
                        d[i][j] = -1;
                    }
                }
            }
            
            while (!q.isEmpty()) {
                int[] point = q.poll();
                int x = point[0];
                int y = point[1];
                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
            
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result += d[i][j];
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}