import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

    static int[][] map;
    static int[] v;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc < 11; tc++) {

            int len = sc.nextInt();
            int start = sc.nextInt();

            map = new int[101][101];
            v = new int[101];

            for (int i = 0; i < len / 2; i++) { // 반만 반복
                int from = sc.nextInt();
                int to = sc.nextInt();

                map[from][to] = 1;
            }

            bfs(start);  // 수정된 부분

            int max = 0;
            int result = 0;
            for (int i = 1; i < 101; i++) {
                if (v[i] > max) {
                    max = v[i];
                    result = i;
                }
                else if (v[i] == max) {
                    if (i > result) {
                        result = i;
                    }
                }
            }
            System.out.println("#" + tc + " " + result); // 테스트 케이스 번호 추가
        }
    }

    static void bfs(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        v[n] = 1; // 시작점을 방문 표시
        queue.offer(n);

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i = 1; i < 101; i++) {
                if (map[poll][i] == 1 && v[i] == 0) {  // 방문하지 않은 노드만 탐색
                    queue.offer(i);
                    v[i] = v[poll] + 1;  // 방문 순서 설정
                }
            }
        }
    }
}