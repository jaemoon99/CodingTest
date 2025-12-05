import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int[] result = bfs(destination, n, graph);
        
        int idx = 0;
        for (int source : sources) {
            answer[idx++] = result[source];
        }
        
        return answer;
    }
    
    public int[] bfs(int end, int n, List<Integer>[] graph) {
        Deque<Integer> dq = new ArrayDeque<>();
        int [] v = new int[n + 1];
        
        Arrays.fill(v, -1);
        
        dq.add(end);
        v[end] = 0;
        
        while (!dq.isEmpty()) {
            int poll = dq.poll();
            
            for (int i = 0; i < graph[poll].size(); i++) {
                if (v[graph[poll].get(i)] == -1) {
                    dq.add(graph[poll].get(i));
                    v[graph[poll].get(i)] = v[poll] + 1;
                }
            }
        }
        
        return v;   
    }
}