import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        dp[1] = 0;
        
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = 1;
        
        if (n < 4) {
            System.out.println(dp[n]);
            return;
        }
        
        for (int i = 4; i <= n; i++) {
            
            int min = dp[i - 1] + 1;
            
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3] + 1);
            }
            
            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2] + 1);
            }
            
            dp[i] = min;
        }
        
        System.out.println(dp[n]);
    }
}