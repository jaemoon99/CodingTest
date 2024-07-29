import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static List<List<Integer>> tree;
    private static boolean[] visited;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        visited[0] = true;
        dfs(0);

        for (int i = 1; i < n; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();
    }

    private static void dfs(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int x = stack.pop();
            for (int near : tree.get(x)) {
                if (!visited[near]) {
                    stack.push(near);
                    visited[near] = true;
                    parent[near] = x + 1;
                }
            }
        }
    }
}
