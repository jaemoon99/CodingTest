import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * count : 감염된 컴퓨터 수
         * computer : 컴퓨터 수
         * connect : 직접 연결된 컴퓨터 쌍의 수
         * checked : 연결된 컴퓨터를 저장하는 배열
         * visited : 감염된 컴퓨터를 저장하는 배열
         */
        int count = 0;
        int computer = sc.nextInt();
        int connect = sc.nextInt();
        int[][] checked = new int[computer + 1][computer + 1];
        int[] visited = new int[computer + 1];

        // 연결된 컴퓨터 저장
        for (int i = 0; i < connect; i++) {
            int front = sc.nextInt();
            int rear = sc.nextInt();
            checked[front][rear] = 1;
            checked[rear][front] = 1;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        // 시작
        queue.add(1);
        // 1번 컴퓨터 감염표시
        visited[1] = 1;
        
        // 빈 큐가 될 때까지 반복
        while (!queue.isEmpty()) {
            // 컴퓨터를 큐에서 꺼냄
            int start = queue.pop();

            

            for (int end = 1; end <= computer; end++) {

                // 현재 컴퓨터와 연결되어 있으면서 감염되지 않은 경우
                if(checked[start][end] == 1 && visited[end] == 0) {
                    // 감염표시
                    visited[end] = 1;
                    queue.add(end);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}