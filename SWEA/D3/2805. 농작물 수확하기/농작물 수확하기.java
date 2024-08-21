import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수
		int T = sc.nextInt();
		// 테스트케이스 개수만큼 순회
		for (int tc = 1; tc <= T; tc++) {
			// 농장 크기
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			// 수확물 입력
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			/**
			 * result : 결과값
			 * start : 수확 시작점
			 * cnt : 수확 시작점으로 부터 수확해야되는 블럭 개수
			 */
			int result = 0;
			int start = N / 2;
			int cnt = 1;
			// 농장 세로크기만큼 순회
			for (int i = 0; i < N; i++) {
				// 시작점과 블럭 개수에 맞게 수확
				for (int j = start; j < start + cnt; j++) {
					result += map[i][j];
				}
				// 위치가 농장의 절반이 이상인 경우
				if (i >= N / 2) {
					start++;
					cnt -= 2;
				}
				// 위치가 농장의 절반 미만일 경우
				if (i < N / 2){
					start--;
					cnt += 2;
				}
			}
			// 결과 출력
			System.out.println("#" + tc + " " + result);
		}
	}
}
