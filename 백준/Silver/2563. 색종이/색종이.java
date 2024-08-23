import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 도형을 그릴 빈 지도
		int[][] map = new int[100][100];
		
		// 결과값
		int result = 0;
		// 좌표 개수
		int N = sc.nextInt();
		// 좌표 입력
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			// 좌표 만큼 도형 그리기
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y +10; k++) {
					// 안그린 부분이면
					if (map[j][k] == 0) {
						// 그림 표시
						map[j][k] = 1;
						// 결과값 증가
						result++;
					}
				}
			}
		}
		// 정답 출력
		System.out.println(result);
	}
}
