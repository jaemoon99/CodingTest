import java.util.Scanner;

public class Solution {

	/*
	 * N : 맵크기
	 * map : 숫자를 담을 배열
	 */
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			String order = sc.next();
			map = new int[N][N];
			
			// 숫자 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 함수 호출
			transformMap(order);
			
			// 결과 출력
			System.out.println("#" + tc);
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	static void transformMap(String order) {
		switch (order) {
			case "up":
				for (int j = 0; j < N; j++) {
					// 합칠 위치
	                int idx = 0;
	                for (int i = 1; i < N; i++) {
	                	// 0이 아니면 임시 저장
	                    if (map[i][j] != 0) {
	                        int temp = map[i][j];
	                        // 원래 map은 삭제
	                        map[i][j] = 0;
	                        // 이동할 위치가 빈 경우
	                        if (map[idx][j] == 0) {
	                        	// 삽입
	                            map[idx][j] = temp;
	                        }
	                        // 이동할 위치의 숫자와 같은 경우
	                        else if (map[idx][j] == temp) {
	                        	// 2배 적용
	                            map[idx][j] *= 2;
	                            // 다음 위치로 이동
	                            idx++;
	                        }
	                        // 이동할 위치의 숫자와 다른 경우
	                        else {
	                        	// 다음 위치로 이동(원래 본인 위치)
	                            idx++;
	                            // 삽입
	                            map[idx][j] = temp;
	                        }
	                    }
	                }
	            }
				break;
			case "down":
				for (int j = 0; j < N; j++) {
					// 합칠 위치
	                int idx = N - 1;
	                for (int i = N - 2; i >= 0; i--) {
	                	// 0이 아니면 임시 저장
	                    if (map[i][j] != 0) {
	                        int temp = map[i][j];
	                        // 원래 map은 삭제
	                        map[i][j] = 0;
	                        // 이동할 위치가 빈 경우
	                        if (map[idx][j] == 0) {
	                        	// 삽입
	                            map[idx][j] = temp;
	                        }
	                        // 이동할 위치의 숫자와 같은 경우
	                        else if (map[idx][j] == temp) {
	                        	// 2배 적용
	                            map[idx][j] *= 2;
	                            // 다음 위치로 이동
	                            idx--;
	                        }
	                        // 이동할 위치의 숫자와 다른 경우
	                        else {
	                        	// 다음 위치로 이동(원래 본인 위치)
	                            idx--;
	                            // 삽입
	                            map[idx][j] = temp;
	                        }
	                    }
	                }
	            }
				break;
			case "left":
				for (int i = 0; i < N; i++) {
					// 합칠 위치
	                int idx = 0;
	                for (int j = 1; j < N; j++) {
	                	// 0이 아니면 임시 저장
	                    if (map[i][j] != 0) {
	                        int temp = map[i][j];
	                        // 원래 map은 삭제
	                        map[i][j] = 0;
	                        // 이동할 위치가 빈 경우
	                        if (map[i][idx] == 0) {
	                        	// 삽입
	                            map[i][idx] = temp;
	                        }
	                        // 이동할 위치의 숫자와 같은 경우
	                        else if (map[i][idx] == temp) {
	                        	// 2배 적용
	                        	map[i][idx] *= 2;
	                            // 다음 위치로 이동
	                            idx++;
	                        }
	                        // 이동할 위치의 숫자와 다른 경우
	                        else {
	                        	// 다음 위치로 이동(원래 본인 위치)
	                            idx++;
	                            // 삽입
	                            map[i][idx] = temp;
	                        }
	                    }
	                }
	            }
				break;
			case "right":
				for (int i = 0; i < N; i++) {
					// 합칠 위치
	                int idx = N - 1;
	                for (int j = N - 2; j >= 0; j--) {
	                	// 0이 아니면 임시 저장
	                    if (map[i][j] != 0) {
	                        int temp = map[i][j];
	                        // 원래 map은 삭제
	                        map[i][j] = 0;
	                        // 이동할 위치가 빈 경우
	                        if (map[i][idx] == 0) {
	                        	// 삽입
	                        	map[i][idx] = temp;
	                        }
	                        // 이동할 위치의 숫자와 같은 경우
	                        else if (map[i][idx] == temp) {
	                        	// 2배 적용
	                        	map[i][idx] *= 2;
	                            // 다음 위치로 이동
	                            idx--;
	                        }
	                        // 이동할 위치의 숫자와 다른 경우
	                        else {
	                        	// 다음 위치로 이동(원래 본인 위치)
	                            idx--;
	                            // 삽입
	                            map[i][idx] = temp;
	                        }
	                    }
	                }
	            }
		}
	}
}
