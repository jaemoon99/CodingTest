import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
 
		int[] map = new int[n + 1];
		int[] dp = new int[n + 1];
 
		for (int i = 1; i <= n; i++) {
			map[i] = sc.nextInt();
		}
 
		dp[1] = map[1];
		if (n > 1) {
			dp[2] = map[1] + map[2];
		}
		
		for (int i = 3; i <= n; i++) {
			int case1 = dp[i - 2] + map[i];
			int case2 = dp[i - 3] + map[i - 1] + map[i];
			dp[i] = Math.max(dp[i - 1], Math.max(case1, case2));
 
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}