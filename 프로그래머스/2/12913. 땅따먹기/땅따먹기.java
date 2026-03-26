class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < land.length; i++) {
            dp[i][0] = land[i][0] + Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][1] = land[i][1] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][2] = land[i][2] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]);
            dp[i][3] = land[i][3] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        }

        int last = land.length - 1;
        return Math.max(Math.max(dp[last][0], dp[last][1]), Math.max(dp[last][2], dp[last][3]));
    }
}