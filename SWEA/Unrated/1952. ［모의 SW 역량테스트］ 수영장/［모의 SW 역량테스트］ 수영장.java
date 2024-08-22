import java.util.Scanner;

public class Solution {

	/**
	 * result : 결과값
	 * month : 월별 이용수
	 * pay : 날짜별 요금
	 */
	static int result;
	static int[] month;
	static int[] pay;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			pay = new int[4];
			// 날짜별 요금 입력
			for (int i = 0; i < 4; i++) {
				pay[i] = sc.nextInt();
			}
			
			month = new int[12];
			// 월별 이용수 입력
			for (int i = 0; i < 12; i++) {
				month[i] = sc.nextInt();
			}
			
			// 초기 결과값 설정
			result = 999_999_999;
			// 함수 호출
			func(0, 0);
			// 1년 요금과 비교 후 최소값 출력
			System.out.println("#" + tc + " " + Math.min(result, pay[3]));
		}
	}
	
	static void func(int cnt, int sum) {
		// 현재 요금이 최소값보다 큰 경우 종료
		if (sum > result) {
			return;
		}
		
		// 12월까지 순회한 경우 최소값 갱신 후 종료
		if(cnt >= 12) {
			result = Math.min(sum, result);
			return ;
		}
		
		// 이용일이 0인 경우는 무시
		if(month[cnt] == 0) {
			func(cnt + 1, sum);
		} else {
			// 하루 이용권
			func(cnt + 1, sum + (month[cnt] * pay[0]));
			// 한 달 이용권
			func(cnt + 1, sum + pay[1]);
			// 세 달 이용권
			func(cnt + 3, sum + pay[2]);
		}
	}
}
