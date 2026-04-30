import java.util.*;

class Solution {
    public int[] solution(int target) {
        int INF = 1_000_000;

        int[][] dp = new int[target + 1][2];

        for (int i = 1; i <= target; i++) {
            dp[i][0] = INF;
            dp[i][1] = 0;
        }

        List<int[]> scores = new ArrayList<>();

        // 싱글
        for (int i = 1; i <= 20; i++) {
            scores.add(new int[]{i, 1});
        }

        // 더블, 트리플
        for (int i = 1; i <= 20; i++) {
            scores.add(new int[]{i * 2, 0});
            scores.add(new int[]{i * 3, 0});
        }

        // 불
        scores.add(new int[]{50, 1});

        for (int i = 1; i <= target; i++) {
            for (int[] score : scores) {
                int point = score[0];
                int bonus = score[1];

                if (i - point < 0) continue;

                int dartCount = dp[i - point][0] + 1;
                int singleOrBull = dp[i - point][1] + bonus;

                if (dartCount < dp[i][0]) {
                    dp[i][0] = dartCount;
                    dp[i][1] = singleOrBull;
                } else if (dartCount == dp[i][0] && singleOrBull > dp[i][1]) {
                    dp[i][1] = singleOrBull;
                }
            }
        }

        return dp[target];
    }
}