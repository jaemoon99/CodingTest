import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        int result = bfs(p1, p2);
        System.out.println(result);
    }
    
    static int bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDepth = current[1];
            
            if (currentNode == target) {
                return currentDepth;
            }
            
            for (int neighbor : graph[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, currentDepth + 1});
                }
            }
        }
        
        return -1;  // 연결되지 않은 경우
    }
}