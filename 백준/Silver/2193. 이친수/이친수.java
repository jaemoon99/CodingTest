import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		if (n == 1) {
			System.out.println(1);
			return;
		}
		
		BigInteger[][] dp = new BigInteger[n + 1][2];
		dp[1][0] = BigInteger.ZERO;
		dp[1][1] = BigInteger.ONE;
		dp[2][0] = BigInteger.ONE;
		dp[2][1] = BigInteger.ZERO;
		
		
		for (int i = 3; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][0].add(dp[i - 2][0]);
			dp[i][1] = dp[i - 1][1].add(dp[i - 2][1]);
		}
		
		System.out.println(dp[n][0].add(dp[n][1]));
				
	}

}
