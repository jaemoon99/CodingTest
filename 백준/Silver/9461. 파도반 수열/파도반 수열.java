import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n =  Integer.parseInt(br.readLine());

            if (n <= 3) {
                sb.append(1).append("\n");
                continue;
            }

            long[] dp = new long[n];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;

            for (int j = 3; j < n; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }

            sb.append(dp[n - 1]).append("\n");
        }

        br.close();

        System.out.println(sb);
    }
}