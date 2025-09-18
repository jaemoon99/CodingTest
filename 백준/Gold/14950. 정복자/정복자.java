import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int parent[], rank[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
				
		List<int[]> link = new ArrayList<>();
		parent = new int[n + 1];
		rank = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			
			link.add(new int[] {a, b, weight});
			
		}
		
		sc.close();
		
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		link.sort(Comparator.comparingInt(arr -> arr[2]));
		
		int result = 0, cnt = 0;
		for (int[] nxt : link) {
			int a = nxt[0];
			int b = nxt[1];
			int weight = nxt[2];
			
			int pa = find(a);
			int pb = find(b);
			
			if (pa == pb) {
				continue;
			}
			
			union(pa, pb);
			
			result += (weight + t * cnt);
			
			cnt++;				
		}
		
		System.out.println(result);
	}
	
	static int find(int x) {
		while (parent[x] != x) {
			x = parent[x];
		}
		
		return x;
	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if (a == b) {
			return;
		}
		
		if (rank[a] < rank[b]) {
			parent[a] = b;
			return;
		}
		
		if (rank[b] < rank[a]) {
			parent[b] = a;
			return;
		}
		
		parent[a] = b;
		rank[b]++;
	}

}
