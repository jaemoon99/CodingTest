import java.util.Scanner;

public class Solution {

	static int[] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc < T + 1; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			
			int n = sc.nextInt();
			int m = sc.nextInt();

			arr = new int[n + 1];
			init(n);
			
			for (int i = 0; i < m; i++) {
				int k = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if (k == 0) {					
					union(k, a, b);
				} else {
					if (union(k, a, b)) {
						sb.append(0);
					} else {
						sb.append(1);
					}
				}
			}
			System.out.println(sb);
			
		}
	}
	
	static void init(int n) {
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}
	}
	
	static int find(int num) {
		if (num == arr[num]) {
			return num;
		}
		return arr[num] = find(arr[num]);
	}
	
	static boolean union(int check, int num1, int num2) {
		num1 = find(num1);
		num2 = find(num2);
		
		if (num1 == num2) {
			return false;
		}
		
		if (check == 0) {			
			arr[num1] = num2;
		}
		
		return true;
	}
}
