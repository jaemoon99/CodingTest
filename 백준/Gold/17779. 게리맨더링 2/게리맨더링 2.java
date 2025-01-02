import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] area = new int[n][n];
		int[][] map = new int[n][n];
		int[] people = new int[5];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				area[i][j] = 4;
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int x1 = 0; x1 < n; x1++) {
			for (int y1 = 1; y1 < n; y1++) {
				// d1과 d2의 범위는 y좌표에 종속됩니다.
				for (int d1 = 1; d1 <= y1; d1++) {
					for (int d2 = 1; d2 < n - y1; d2++) {
						// 맨 아래의 꼭지점이 범위를 벗어날 때 예외 처리
						int x4 = x1 + d1 + d2;
						int y4 = y1 + d2 - d1;
						
						if (x4 < 0 || x4 >= n || y4 < 0 || y4 >= n) continue;
						
						// 2개의 꼭지점을 추가적으로 구해줍니다.
						int x2 = x1 + d1;
						int x3 = x1 + d2;
						
						// 4개의 꼭지점으로부터 선거구를 나눕니다.
						int adjust = 0;
						
						// 1번 선거구
						for (int i = 0; i < x2; i++) {
							// 첫 번째 꼭지점보다 크거나 같을 때부터 조정하기
							if (i >= x1) adjust++;
							
							for (int j = 0; j <= y1 - adjust; j++) {
								area[i][j] = 0;
							}
						}
						
						adjust = 0;
						
						// 2번 선거구
						for (int i = 0; i <= x3; i++) {
							// 첫 번째 꼭지점보다 클 때부터 조정하기
							if (i > x1) adjust++;
							
							for (int j = y1 + 1 + adjust; j < n; j++) {
								area[i][j] = 1;
							}
						}
						
						adjust = 0;
						
						// 3번 선거구
						for (int i = n - 1; i >= x2; i--) {
							// 네 번째 꼭지점보다 작아질 때부터 조정하기
							if (i < x4) adjust++;
							
							for (int j = 0; j < y4 - adjust; j++) {
								area[i][j] = 2;
							}
						}
						
						adjust = 0;
						
						// 4번 선거구
						for (int i = n - 1; i > x3; i--) {
							// 네 번째 꼭지점보다 작거나 같을 때부터 조정하기
							if (i <= x4) adjust++;
							
							for (int j = y4 + adjust; j < n; j++) {
								area[i][j] = 3;
							}
						}
						
						// 나눈 선거구의 인구 총합 구하기
						for (int i = 0; i < n; i++) {
							for (int j = 0; j < n; j++) {
								people[area[i][j]] += map[i][j];
								area[i][j] = 4; // 선거구는 다시 기본 5번 선거구로 초기화
							}
						}
						
						Arrays.sort(people);
						result = Math.min(result, people[4] - people[0]);
						Arrays.fill(people, 0);
					}
				}
			}
		}

		System.out.println(result);
		
		sc.close();
	}
}