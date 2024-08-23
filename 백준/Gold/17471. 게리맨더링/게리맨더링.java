import java.util.*;

public class Main {
    static int N; // 구역의 수
    static int[] population; // 각 구역의 인구 수
    static ArrayList<ArrayList<Integer>> adj; // 인접 리스트로 표현된 그래프
    static boolean[] visited; // 방문 체크 배열
    static int minDiff = Integer.MAX_VALUE; // 인구 차이의 최소값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        population = new int[N + 1];
        adj = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
            adj.add(new ArrayList<>());
        }
        
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int neighbor = sc.nextInt();
                adj.get(i - 1).add(neighbor);
            }
        }
        
        // 가능한 모든 부분집합을 구해 두 그룹으로 나눔
        for (int i = 1; i <= N / 2; i++) {
            comb(new int[i], 1, 0);
        }
        
        // 결과 출력
        if (minDiff == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDiff);
        }
    }
    
    // 조합을 생성하여 두 그룹으로 나누기
    static void comb(int[] sel, int idx, int k) {
        if (k == sel.length) {
            check(sel);
            return;
        }
        if (idx > N) return;
        
        sel[k] = idx;
        comb(sel, idx + 1, k + 1);
        comb(sel, idx + 1, k);
    }
    
    // 그룹이 연결되어 있는지 확인
    static void check(int[] groupA) {
        visited = new boolean[N + 1];
        int groupASum = bfs(groupA, true);
        
        // 그룹 A가 연결되어 있지 않으면
        if (groupASum == -1) return;
        
        List<Integer> groupBList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) groupBList.add(i);
        }
        
        int[] groupB = new int[groupBList.size()];
        for (int i = 0; i < groupBList.size(); i++) {
            groupB[i] = groupBList.get(i);
        }
        
        int groupBSum = bfs(groupB, false);
        
        // 그룹 B가 연결되어 있지 않으면
        if (groupBSum == -1) return;
        
        // 두 그룹의 인구 차이를 계산하여 최소값 갱신
        minDiff = Math.min(minDiff, Math.abs(groupASum - groupBSum));
    }
    
    // BFS를 통해 연결성과 인구 합 계산
    static int bfs(int[] group, boolean markVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group[0]);
        visited[group[0]] = true;
        
        int sum = 0;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sum += population[cur];
            count++;
            
            for (int next : adj.get(cur - 1)) {
                if (!visited[next] && contains(group, next)) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        // 그룹 내 모든 노드를 방문하지 못했다면 연결되지 않은 것으로 간주
        return (count == group.length) ? sum : -1;
    }
    
    // 그룹에 특정 노드가 포함되어 있는지 확인
    static boolean contains(int[] group, int node) {
        for (int n : group) {
            if (n == node) return true;
        }
        return false;
    }
}
