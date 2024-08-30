import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	static int n;
	static int[] parents;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt() + 1;
		for (int tc = 1; tc < T; tc++) {
			n = sc.nextInt();
			int[] xList = new int[n + 1];
			int[] yList = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				xList[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= n; i++) {
				yList[i] = sc.nextInt();
			}
			
			double e = sc.nextDouble();
			
			make(n);
			
			ArrayList<Edge> edges = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n; j++) {
					edges.add(new Edge(i, j, (Math.pow(Math.abs(xList[i] - xList[j]), 2) + Math.pow(Math.abs(yList[i] - yList[j]), 2)) * e));
				}
			}
			
			Collections.sort(edges);
			
			int cnt = 0;
			double result = 0.0;
			for (Edge edge : edges) {
				if (union(edge.start, edge.end)) {
					cnt++;
					result += edge.weight;
				}
				
				if (cnt == n - 1) {
					break;
				}
			}
			System.out.println("#" + tc + " " + Math.round(result));
		}
	}
	
	static void make(int v) {
		parents = new int[v + 1];
		for (int i = 1; i <= v; i++) {
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
		
		if (start == end) return false;
		
		parents[start] = end;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int start, end;
		double weight;

		public Edge(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
		
	}
}
