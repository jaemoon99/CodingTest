import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
        	parent[i] = i;
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int[] count = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
        	count[find(i)]++;
        }

        long result = 1;
        for (int i = 1; i < n + 1; ++i) {
        	if (parent[i] == i) {
            	result = (result * count[i]) % MOD;
            }
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if (parentA == parentB) {
        	return;
        }

        if (parentA < parentB) {
        	parent[parentB] = parentA;
        	return;
        }
        
        parent[parentA] = parentB;
    }

    static int find(int x) {
        if (parent[x] != x) {
        	parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }

}
