import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 999_999_999;
        
        int[][] graph = new int[n + 1][n + 1];
        
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;
            
            int result = bfs(1, n, graph);
            
            if (answer > result) {
                answer = result;
            }
            
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int start, int n, int[][] graph) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] v = new boolean[n + 1];
        
        dq.add(start);
        v[start] = true;
        
        int cnt = 0;
        while (!dq.isEmpty()) {
            int poll = dq.poll();
            cnt++;
            
            for (int i = 1; i <= n; i++) {
                if (graph[i][poll] == 1 && v[i] == false) {
                    dq.add(i);
                    v[i] = true;
                }
            }
        }
        
        return Math.abs(n - cnt - cnt);
    }
}