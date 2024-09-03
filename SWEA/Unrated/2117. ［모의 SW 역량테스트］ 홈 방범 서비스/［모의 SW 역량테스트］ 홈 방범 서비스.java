import java.util.Scanner;

public class Solution {
    // 메인 함수: 프로그램 실행 시작점
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 수 입력

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = scanner.nextInt(); // 그리드의 크기 (NxN)
            int M = scanner.nextInt(); // 집 한 채당 이익

            // 그리드 초기화
            int[][] grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            // 최대 커버 가능한 집의 수 저장 변수
            int maxHousesCovered = 0;

            // 그리드의 각 셀을 서비스 중심으로 고려
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    // 서비스 범위 K 값을 변화시키며 탐색
                    for (int K = 1; K <= N + 1; K++) {
                        // 해당 구성에서 커버할 수 있는 집의 수 계산
                        int housesCovered = countHousesCovered(grid, x, y, K, N);
                        // 운영 비용 계산
                        int cost = K * K + (K - 1) * (K - 1);

                        // 총 수익 계산
                        int income = housesCovered * M;

                        // 운영이 수익성 있는지 확인
                        if (income >= cost) {
                            maxHousesCovered = Math.max(maxHousesCovered, housesCovered);
                        }
                    }
                }
            }

            // 현재 테스트 케이스의 결과 출력
            System.out.println("#" + test_case + " " + maxHousesCovered);
        }

        scanner.close();
    }

    // 주어진 범위 K 내에서 커버할 수 있는 집의 수를 계산하는 함수
    private static int countHousesCovered(int[][] grid, int centerX, int centerY, int K, int N) {
        int count = 0;

        // 그리드를 순회하며 범위 K 내에 있는 집을 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 중심 (centerX, centerY)에서 (i, j)까지의 맨해튼 거리 계산
                int distance = Math.abs(centerX - i) + Math.abs(centerY - j);

                // 해당 집이 서비스 범위 내에 있는지 확인
                if (distance < K && grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count; // 커버된 집의 수 반환
    }
}