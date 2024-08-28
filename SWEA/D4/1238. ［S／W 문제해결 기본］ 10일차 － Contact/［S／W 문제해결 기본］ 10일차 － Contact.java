import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

	/**
	 * map : 연결된 사람 그래프
	 * v : 방문 확인용 배열
	 */
    static int[][] graph;
    static int[] v;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc < 11; tc++) {
        	// 연결 길이
            int len = sc.nextInt();
            // 시작 번호
            int start = sc.nextInt();

            graph = new int[101][101];
            v = new int[101];

            // 반만 반복
            for (int i = 0; i < len / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                // 연결 표시
                graph[from][to] = 1;
            }

            bfs(start);

            // 연결 최대 길이
            int max = 0;
            // 연결 최대 길이 중 최대 번호
            int result = 0;
            for (int i = 1; i < 101; i++) {
            	// 길이 비교
                if (v[i] > max) {
                    max = v[i];
                    result = i;
                }
                else if (v[i] == max) {
                	// 번호 비교
                    if (i > result) {
                        result = i;
                    }
                }
            }
            // 결고 출력
            System.out.println("#" + tc + " " + result);
        }
    }

    static void bfs(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        // 방문 표시
        v[n] = 1;
        queue.offer(n);

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            // 본인이 연락할 수 있는 사람 순회
            for (int i = 1; i < 101; i++) {
            	// 연락할 수 있고 연락받지 않은 경우
                if (graph[poll][i] == 1 && v[i] == 0) {
                    queue.offer(i);
                    // 길이 증가
                    v[i] = v[poll] + 1;
                }
            }
        }
    }
}