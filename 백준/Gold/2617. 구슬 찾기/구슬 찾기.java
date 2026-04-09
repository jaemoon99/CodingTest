import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static List<Integer>[] graph;
    static List<Integer>[] reverseGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            reverseGraph[b].add(a);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int bigger = dfs(i, graph, visited) - 1;

            visited = new boolean[n + 1];
            int smaller = dfs(i, reverseGraph, visited) - 1;

            if (bigger > n / 2 || smaller > n / 2) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int dfs(int idx, List<Integer>[] g, boolean[] visited) {
        visited[idx] = true;
        int count = 1;

        for (int next : g[idx]) {
            if (!visited[next]) {
                count += dfs(next, g, visited);
            }
        }

        return count;
    }
}