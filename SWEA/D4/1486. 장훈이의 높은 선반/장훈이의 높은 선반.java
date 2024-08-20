import java.util.Scanner;

public class Solution {

	/**
	 * N : 직원 수
	 * B : 사다리 길이
	 * result : 직원 키 합
	 * tList : 직원 키 배열
	 */
	static int N;
	static int B;
	static int result;
	static int[] tList;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			tList = new int[N];
			
			// 직원 키 입력
			for (int i = 0; i < N; i++) {
				tList[i] = sc.nextInt();
			}
			
			// 결과
			result = 999_999_999;
			// 함수 실행
			func(0, 0);
			// 결과 출력
			System.out.println("#" + tc + " " + (result - B));
		}
	}
	
	static void func(int cnt, int sum) {
		// 현재까지의 합이 B 이상이면 최소값 갱신
        if (sum >= B) {
            result = Math.min(result, sum);
            return;
        }

        // 모든 요소를 다 검사한 경우
        if (cnt == N) {
            return;
        }

        // 현재 요소를 포함하는 경우
        func(cnt + 1, sum + tList[cnt]);
        
        // 현재 요소를 포함하지 않는 경우
        func(cnt + 1, sum);
    }
}
