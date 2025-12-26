import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        if (n == 1) {
            System.out.println(scores[0]);
            return;
        }
        if (n == 2) {
            System.out.println(scores[0] + scores[1]);
            return;
        }

        int[] dp = new int[n];

        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];
        dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }

        System.out.println(dp[n - 1]);
    }
}