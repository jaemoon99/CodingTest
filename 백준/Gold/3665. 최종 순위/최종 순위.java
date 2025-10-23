import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] lastYear = new int[n];
            int[][] graph = new int[n + 1][n + 1];
            int[] indegree = new int[n + 1];

            for (int i = 0; i < n; i++) {
                lastYear[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int higher = lastYear[i];
                    int lower = lastYear[j];
                    if (graph[higher][lower] == 0) {
                        graph[higher][lower] = 1;
                        indegree[lower]++;
                    }
                }
            }

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (graph[a][b] == 1) {
                    graph[a][b] = 0;
                    graph[b][a] = 1;
                    
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[b][a] = 0;
                    graph[a][b] = 1;
                    
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                	q.add(i);
                }
            }

            List<Integer> result = new ArrayList<>();
            boolean ambiguous = false;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (q.isEmpty()) {
                    impossible = true;
                    break;
                }

                if (q.size() > 1) {
                    ambiguous = true;
                }

                int now = q.poll();
                result.add(now);

                for (int next = 1; next <= n; next++) {
                    if (graph[now][next] == 1) {
                        indegree[next]--;
                        
                        if (indegree[next] == 0) {
                        	q.add(next);
                        }
                    }
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else if (ambiguous) {
                System.out.println("?");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i > 0) {
                    	System.out.print(" ");
                    }
                    System.out.print(result.get(i));
                }
                System.out.println();
            }
        }

        sc.close();
    }
}