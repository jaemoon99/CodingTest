import java.util.Scanner;

public class Solution {

	/**
	 * n : 무리(사람) 수
	 * group : 무리의 장을 나타낼 배열
	 */
	static int n;
	static int[] group;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			n = sc.nextInt();
			// 병합 횟수
			int m = sc.nextInt();
			
			group = new int[n + 1];
			
			// 배열 초기화
			init(n);
			
			// 병합 횟수만큼 반복
			for (int i = 0; i < m; i++) {
				// 각각 사람 번호
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				
				// 합집합 연산
				union(p1, p2);
			}
			// 정답 출력
			System.out.println("#" + tc + " " + n);
		}
	}
	
	static void init(int n) {
		// 부모를 자기 자신으로 초기화
		for (int i = 1; i < n + 1; i++) {
			group[i] = i;
		}
	}
	
	static int find(int num) {
		// 부모가 본인인 경우
		if (num == group[num]) {
			return num;
		}
		
		// 부모가 본인이 아닌 경우 탐색
		return group[num] = find(group[num]);
		
	}
	
	static void union(int num1, int num2) {
		// 각각 부모 탐색
		num1 = find(num1);
		num2 = find(num2);
		
		// 같은 무리인 경우
		if (num1 == num2) {
			return;
		}
		
		// 다른 무리인 경우 병합
		group[num1] = num2;
		// 무리 수 감소
		n--;
	}
}
