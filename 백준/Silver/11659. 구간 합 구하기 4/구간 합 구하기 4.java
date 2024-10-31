import java.util.Scanner;

public class Main {

	static int n, m, map[], v[];
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n + 1];
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = sc.nextInt();
			sum[i] = map[i] + sum[i - 1];
		}
		
		
		for (int i = 0; i < m; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(sum[k] - sum[j - 1]);
		}
	}	
}