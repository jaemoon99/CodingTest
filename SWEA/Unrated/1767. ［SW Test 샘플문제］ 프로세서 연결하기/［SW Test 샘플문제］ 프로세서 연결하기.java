import java.util.*;

public class Solution {
    static int N; // 회로판의 크기
    static int[][] map; // 회로판
    static List<int[]> cores; // 코어의 좌표 리스트
    static int minWireLength; // 최소 전선 길이
    static int maxConnectedCores; // 연결된 최대 코어 수
    static int totalCores; // 코어의 총 개수

    // 상하좌우 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 회로판 크기
            map = new int[N][N];
            cores = new ArrayList<>();

            // 회로판 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    // 가장자리가 아닌 코어만 리스트에 추가
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
                        cores.add(new int[]{i, j});
                    }
                }
            }

            totalCores = cores.size(); // 코어의 총 개수
            minWireLength = Integer.MAX_VALUE; // 초기값: 매우 큰 값
            maxConnectedCores = 0; // 초기값: 0

            // 백트래킹으로 해결
            backtrack(0, 0, 0);

            System.out.println("#" + t + " " + minWireLength);
        }
        sc.close();
    }

    // 백트래킹 메서드
    // idx: 현재 처리 중인 코어의 인덱스
    // connectedCores: 현재까지 연결된 코어 수
    // wireLength: 현재까지 사용한 전선의 총 길이
    private static void backtrack(int idx, int connectedCores, int wireLength) {
        // 모든 코어를 처리한 경우
        if (idx == totalCores) {
            // 더 많은 코어를 연결했거나, 같은 수의 코어를 연결하면서 전선 길이가 짧은 경우 갱신
            if (connectedCores > maxConnectedCores || 
                (connectedCores == maxConnectedCores && wireLength < minWireLength)) {
                maxConnectedCores = connectedCores;
                minWireLength = wireLength;
            }
            return;
        }

        int[] core = cores.get(idx);
        int x = core[0], y = core[1];

        // 4방향으로 시도
        for (int d = 0; d < 4; d++) {
            int len = canConnect(x, y, d); // 전선을 연결할 수 있는지 확인
            if (len > 0) { // 연결 가능
                placeWire(x, y, d, 2); // 전선을 놓음 (표시: 2)
                backtrack(idx + 1, connectedCores + 1, wireLength + len); // 다음 코어로 이동
                placeWire(x, y, d, 0); // 전선을 다시 제거
            }
        }

        // 연결하지 않고 다음 코어로 이동
        backtrack(idx + 1, connectedCores, wireLength);
    }

    // 전선을 놓을 수 있는지 확인하는 메서드
    // x, y: 코어의 좌표
    // d: 방향 (0: 상, 1: 하, 2: 좌, 3: 우)
    // 전선을 놓을 수 있으면 전선의 길이 반환, 놓을 수 없으면 -1 반환
    private static int canConnect(int x, int y, int d) {
        int nx = x, ny = y;
        int len = 0;

        while (true) {
            nx += dx[d];
            ny += dy[d];

            // 경계를 벗어난 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

            // 다른 코어나 전선이 있는 경우
            if (map[nx][ny] != 0) return -1;

            len++;
        }

        return len; // 연결 가능한 경우 전선 길이 반환
    }

    // 전선을 놓거나 제거하는 메서드
    // x, y: 코어의 좌표
    // d: 방향
    // val: 놓을 값 (2: 전선 놓기, 0: 전선 제거)
    private static void placeWire(int x, int y, int d, int val) {
        int nx = x, ny = y;

        while (true) {
            nx += dx[d];
            ny += dy[d];

            // 경계를 벗어나면 종료
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

            map[nx][ny] = val; // 전선을 놓거나 제거
        }
    }
}