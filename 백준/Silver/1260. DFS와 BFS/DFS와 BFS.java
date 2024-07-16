import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /**
         * n : 정점의 개수
         * m : 간선의 개수
         * v : 시작할 정점의 번호
         */
        int n = sc.nextInt() + 1;
        int m = sc.nextInt();
        int v = sc.nextInt();

        /**
         * arr : 연결된 노드를 표시한 배열
         * visited : 방문한 노드를 체크할 배열
         */
        int[][] checked = new int[n][n];
        int[][] visited = new int[n][n];

        // 연결된 노드를 arr 배열에 체크
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            // 양방향 체크
            checked[start][end] = 1;
            checked[end][start] = 1;
        }

        dfs(checked, visited, v);
        System.out.println();

        // 방문 초기화
        visited = new int[n][n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        bfs(checked, visited, queue);
    }

    public static void dfs(int[][] checked, int[][] visited, int start) {
        // 방문한 노드 출력
        System.out.print(start + " ");

        // 출력한 노드 방문 표시(다른 노드로 부터 도착할 경우)
        for (int i = 0; i < visited.length; i++) {
            visited[i][start] = 1;
        }

        for (int end = 0; end < checked.length; end++) {
            // 서로 연결된 노드이면서 방문하지 않은 노드 탐색
            if (checked[start][end] == 1 && visited[start][end] == 0) {
                dfs(checked, visited, end);
            }
        }
    }

    public static void bfs(int[][] checked, int[][] visited, Deque<Integer> queue) {
        while (!queue.isEmpty()) {
            int start = queue.pop();
            // 방문한 노드 출력
            System.out.print(start + " ");

            // 출력한 노드 방문 표시(다른 노드로 부터 도착할 경우)
            for (int i = 0; i < visited.length; i++) {
                visited[i][start] = 1;
            }

            for (int end = 0; end < checked.length; end++) {
                // 서로 연결된 노드이면서 방문하지 않은 노드 탐색
                if (checked[start][end] == 1 && visited[start][end] == 0) {
                    // 큐에 없는 노드만 추가
                    if (!queue.contains(end)) {
                        queue.add(end);
                    }
                }
            }
        }
    }
}