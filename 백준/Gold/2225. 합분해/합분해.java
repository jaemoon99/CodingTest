import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputNK = br.readLine().split(" ");

		int n = Integer.parseInt(inputNK[0]);
		int k = Integer.parseInt(inputNK[1]);

		int[][] dp = new int[k + 1][n + 1];

		for (int i = 1; i <= k; i++) {
			dp[i][0] = 1;
		}

		for (int j = 0; j <= n; j++) {
			dp[1][j] = 1;
		}

		for (int i = 2; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
			}
		}

		System.out.println(dp[k][n]);
	}
}