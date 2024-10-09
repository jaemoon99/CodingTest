import java.util.Scanner;

public class Main {
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 동, 서, 북, 남
    static int[] dice = new int[6]; // 주사위의 상태를 나타내는 배열

    static void moveDice(int direction) {
        int[] temp = dice.clone(); // 주사위의 현재 상태를 복사
        if (direction == 0) { // 동
            dice[0] = temp[3];
            dice[2] = temp[0];
            dice[3] = temp[5];
            dice[5] = temp[2];
            dice[1] = temp[1];
            dice[4] = temp[4];
        } else if (direction == 1) { // 서
            dice[0] = temp[2];
            dice[2] = temp[5];
            dice[3] = temp[0];
            dice[5] = temp[3];
            dice[1] = temp[1];
            dice[4] = temp[4];
        } else if (direction == 2) { // 북
            dice[0] = temp[1];
            dice[1] = temp[5];
            dice[4] = temp[0];
            dice[5] = temp[4];
            dice[2] = temp[2];
            dice[3] = temp[3];
        } else if (direction == 3) { // 남
            dice[0] = temp[4];
            dice[1] = temp[0];
            dice[4] = temp[5];
            dice[5] = temp[1];
            dice[2] = temp[2];
            dice[3] = temp[3];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int[] commands = new int[k];
        for (int i = 0; i < k; i++) {
            commands[i] = scanner.nextInt();
        }

        for (int command : commands) {
            int dx = directions[command - 1][0];
            int dy = directions[command - 1][1];

            int nx = x + dx;
            int ny = y + dy;

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue; // 범위를 벗어나면 무시
            }

            x = nx;
            y = ny;

            moveDice(command - 1);

            if (board[x][y] == 0) {
                board[x][y] = dice[5];
            } else {
                dice[5] = board[x][y];
                board[x][y] = 0;
            }

            System.out.println(dice[0]);
        }

        scanner.close();
    }
}
