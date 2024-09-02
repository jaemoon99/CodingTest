import java.util.Scanner;

public class Solution {
    
    // 특정 구역에서 최대 수익을 계산하는 함수
    private static int getMaxProfit(int[] honey, int C) {
        int n = honey.length;
        int maxProfit = 0;
        
        // 모든 부분 집합을 탐색하여 최대 수익 계산
        for (int i = 0; i < (1 << n); i++) {
            int totalHoney = 0;
            int profit = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // i의 j번째 비트가 1이면
                    totalHoney += honey[j];
                    profit += honey[j] * honey[j];
                }
            }
            if (totalHoney <= C) {
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        
        return maxProfit;
    }
    
    // 두 일꾼이 꿀을 채취하는 조합에서 최대 수익을 찾는 함수
    private static int solveHoneyHarvest(int N, int M, int C, int[][] grid) {
        int[][] maxProfits = new int[N][N - M + 1];
        
        // 각 구역에 대해 최대 수익 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                int[] honey = new int[M];
                for (int k = 0; k < M; k++) {
                    honey[k] = grid[i][j + k];
                }
                maxProfits[i][j] = getMaxProfit(honey, C);
            }
        }

        // 두 일꾼의 조합으로 최대 수익 찾기
        int answer = 0;
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 <= N - M; j1++) {
                for (int i2 = i1; i2 < N; i2++) {
                    int startJ2 = (i1 == i2) ? j1 + M : 0;
                    for (int j2 = startJ2; j2 <= N - M; j2++) {
                        answer = Math.max(answer, maxProfits[i1][j1] + maxProfits[i2][j2]);
                    }
                }
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 벌집 크기 N
            int M = sc.nextInt(); // 일꾼이 선택할 수 있는 연속된 벌통의 수 M
            int C = sc.nextInt(); // 벌꿀 최대 채취량 C
            int[][] grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int result = solveHoneyHarvest(N, M, C, grid);
            System.out.println("#" + tc + " " + result);
        }

        sc.close();
    }
}