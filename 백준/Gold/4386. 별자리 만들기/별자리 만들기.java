import java.util.*;

public class Main {
    
    static int[] parent;
    
    static class Edge implements Comparable<Edge> {
        int u, v;
        double w;
        
        Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;
        parent[pb] = pa;
        return true;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        double[][] stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            stars[i][0] = sc.nextDouble();
            stars[i][1] = sc.nextDouble();
        }
        sc.close();
        
        // 간선 리스트 만들기
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double dx = stars[i][0] - stars[j][0];
                double dy = stars[i][1] - stars[j][1];
                double dist = Math.sqrt(dx*dx + dy*dy);
                edges.add(new Edge(i, j, dist));
            }
        }
        
        Collections.sort(edges);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        double result = 0;
        int cnt = 0;
        
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                result += e.w;
                cnt++;
                if (cnt == n - 1) break;
            }
        }
        
        System.out.printf("%.2f\n", result);
    }
}