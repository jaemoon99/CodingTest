import java.util.Scanner;

public class Solution {
    public static void move(int[][] board, int N, String direction) {
        if (direction.equals("up")) {
            for (int j = 0; j < N; j++) {
                int idx = 0;
                for (int i = 1; i < N; i++) {
                    if (board[i][j] != 0) {
                        int temp = board[i][j];
                        board[i][j] = 0;
                        if (board[idx][j] == 0) {
                            board[idx][j] = temp;
                        } else if (board[idx][j] == temp) {
                            board[idx][j] *= 2;
                            idx++;
                        } else {
                            idx++;
                            board[idx][j] = temp;
                        }
                    }
                }
            }
        } else if (direction.equals("down")) {
            for (int j = 0; j < N; j++) {
                int idx = N - 1;
                for (int i = N - 2; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        int temp = board[i][j];
                        board[i][j] = 0;
                        if (board[idx][j] == 0) {
                            board[idx][j] = temp;
                        } else if (board[idx][j] == temp) {
                            board[idx][j] *= 2;
                            idx--;
                        } else {
                            idx--;
                            board[idx][j] = temp;
                        }
                    }
                }
            }
        } else if (direction.equals("left")) {
            for (int i = 0; i < N; i++) {
                int idx = 0;
                for (int j = 1; j < N; j++) {
                    if (board[i][j] != 0) {
                        int temp = board[i][j];
                        board[i][j] = 0;
                        if (board[i][idx] == 0) {
                            board[i][idx] = temp;
                        } else if (board[i][idx] == temp) {
                            board[i][idx] *= 2;
                            idx++;
                        } else {
                            idx++;
                            board[i][idx] = temp;
                        }
                    }
                }
            }
        } else if (direction.equals("right")) {
            for (int i = 0; i < N; i++) {
                int idx = N - 1;
                for (int j = N - 2; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        int temp = board[i][j];
                        board[i][j] = 0;
                        if (board[i][idx] == 0) {
                            board[i][idx] = temp;
                        } else if (board[i][idx] == temp) {
                            board[i][idx] *= 2;
                            idx--;
                        } else {
                            idx--;
                            board[i][idx] = temp;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            String direction = sc.next();
            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            move(board, N, direction);

            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
