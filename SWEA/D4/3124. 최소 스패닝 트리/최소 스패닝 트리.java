import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] parents; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt() + 1;
		for (int tc = 1; tc < T; tc++) {
			
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			Edge[] edges = new Edge[e];
			for (int i = 0; i < e; i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			Arrays.sort(edges);
			
			make(v);
			
			int cnt = 0;
			long result = 0;
			for (Edge edge : edges) {
				if (union(edge.start, edge.end)) {
					cnt++;
					result += edge.weight;
					
					if (cnt == v - 1) {
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

	static void make(int v) {
		parents = new int[v + 1];
		for (int i = 1; i < v + 1; i++) {
			parents[i] = -1;
		}
	}
	
	static int findSet(int num) {
		if (parents[num] == -1) {
			return num;
		}
		
		return parents[num] = findSet(parents[num]);
	}
	
	static boolean union(int start, int end) {
		start = findSet(start);
		end = findSet(end);
		
		if (start == end) {
			return false;
		}
		
		parents[start] = end;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
