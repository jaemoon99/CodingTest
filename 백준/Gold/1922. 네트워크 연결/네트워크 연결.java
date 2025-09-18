import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<int[]>[] graph = new ArrayList[n + 1];
		int[] v = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
		    graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		sc.close();
		
		int result = 0;
		int cnt = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[] {1, 0});
		
		while (!pq.isEmpty()) {
			
			if (cnt == n) {
				break;
			}
			
			int[] poll = pq.poll();
			
			int node = poll[0];
			int weight = poll[1];
			
			if (v[node] == 0) {
				v[node] = 1;
				result += weight;
				cnt++;
				
				for (int[] nxt : graph[node]) {
					pq.add(nxt);
				}
			}
			
		}
		
		System.out.println(result);
	}

}
