import java.util.Scanner;

public class Solution {

	static int n;
	static int[] group;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			
			group = new int[n + 1];
			
			init(n);
			
			for (int i = 0; i < m; i++) {
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				
				union(p1, p2);
			}
			
			System.out.println("#" + tc + " " + n);
		}
	}
	
	static void init(int n) {
		for (int i = 1; i < n + 1; i++) {
			group[i] = i;
		}
	}
	
	static int find(int num) {
		if (num == group[num]) {
			return num;
		}
		
		return group[num] = find(group[num]);
		
	}
	
	static void union(int num1, int num2) {
		num1 = find(num1);
		num2 = find(num2);
		
		if (num1 == num2) {
			return;
		}
		
		group[num1] = num2;
		
		n--;
	}
}
