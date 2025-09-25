import java.util.*;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 회원 수
        int[][] dist = new int[n + 1][n + 1];
        
        // 초기 거리값 세팅
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 1000); // 충분히 큰 값
            dist[i][i] = 0;
        }

        // 관계 입력
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == -1 && b == -1) {
            	break;
            }
            dist[a][b] = 1;
            dist[b][a] = 1;
        }
        sc.close();

        // 플로이드-워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 점수 계산 (각 사람의 최대 거리)
        int[] score = new int[n + 1];
        int minScore = 1000;
        for (int i = 1; i <= n; i++) {
            int maxDist = 0;
            for (int j = 1; j <= n; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
            score[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        // 회장 후보들 수집
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (score[i] == minScore) {
                candidates.add(i);
            }
        }

        // 출력
        System.out.println(minScore + " " + candidates.size());
        for (int c : candidates) {
            System.out.print(c + " ");
        }
    }
}