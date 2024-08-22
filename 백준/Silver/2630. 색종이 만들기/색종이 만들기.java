import java.util.Scanner;

public class Main {

	/**
	 * white : 흰색 종이 개수
	 * blue : 파란색 종이 개수
	 * map : 전체 종이
	 */
	static int white;
	static int blue;
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 종이 한 변 길이
		int N = sc.nextInt();
		white = 0;
		blue = 0;
		map = new int[N][N];
		// 종이 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 함수 호출
		func(0, 0, N);
		// 정답 출력
		System.out.println(white + "\n" + blue);
	}
	
	static void func(int x, int y, int len) {
		
		// 종이의 색이 하나인 경우
		if (check(x, y, len)) {
			// 색상 판별
			if (map[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		// 아닌 경우 4등분으로 나눔
		int newLen = len / 2;
		// 1사분면
		func(x, y + newLen, newLen);
		// 2사분면
		func(x, y, newLen);
		// 3사분면
		func(x + newLen, y, newLen);
		// 4사분면
		func(x + newLen, y + newLen, newLen);
	}
	
	static boolean check(int x, int y, int len) {
		
		// 종이가 하나의 색인지 체크
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (map[i][j] != map[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
}
