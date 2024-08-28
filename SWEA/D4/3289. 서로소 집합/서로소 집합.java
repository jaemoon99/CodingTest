import java.util.Scanner;

public class Solution {

	// 부모 체크용 배열
	static int[] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 수
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			// 출력용 스트링빌더
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			
			// 집합 개수
			int n = sc.nextInt();
			// 연산 개수
			int m = sc.nextInt();

			arr = new int[n + 1];
			// 배열 초기화
			init(n);
			
			// 연산 개수만큼 반복
			for (int i = 0; i < m; i++) {
				// 연산
				int k = sc.nextInt();
				// 원소 num1, num2
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				
				// 연산이 0일 경우 합집합 연산
				if (k == 0) {
					union(k, num1, num2);
				}
				// 연산이 1일 경우
				else {
					// 서로 다른 집합인 경우
					if (union(k, num1, num2)) {
						sb.append(0);
					}
					// 같은 집합인 경우
					else {
						sb.append(1);
					}
				}
			}
			// 정답 출력
			System.out.println(sb);
			
		}
	}
	
	static void init(int n) {
		// 부모를 자기 자신으로 초기화
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}
	}
	
	static int find(int num) {
		// 자기 자신이 부모인 경우
		if (num == arr[num]) {
			return num;
		}
		// 부모 찾아 올라가기
		return arr[num] = find(arr[num]);
	}
	
	static boolean union(int check, int num1, int num2) {
		// 각 번호에 해당하는 부모 찾기
		num1 = find(num1);
		num2 = find(num2);
		
		// 같은 집합인 경우
		if (num1 == num2) {
			return false;
		}
		
		// 연산이 0인 경우 합집합 연산
		if (check == 0) {			
			arr[num1] = num2;
		}
		
		return true;
	}
}
