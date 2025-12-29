import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10_007;
        }

        System.out.println(dp[n - 1]);
    }
}