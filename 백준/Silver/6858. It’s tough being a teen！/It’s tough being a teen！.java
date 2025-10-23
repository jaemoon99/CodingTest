import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int n = 7;
		
		List<Integer>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] inDegree = new int[n + 1];
		
		int[][] base = {{1,7}, {1,4}, {2,1}, {3,4}, {3,5}};
		for (int[] ele : base) {
			int a = ele[0];
			int b = ele[1];
			
			list[a].add(b);
			inDegree[b]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (a == 0 && b == 0) {
				break;
			}
			
			list[a].add(b);
			inDegree[b]++;
		}
		
		sc.close();
		
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		String result = "";
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			result += cur + " ";
			cnt++;
			
			for (int next : list[cur]) {
				if (--inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		if (cnt != n) {
			System.out.println("Cannot complete these tasks. Going to bed.");
			return;
		}
		
		System.out.println(result);
	}
}
