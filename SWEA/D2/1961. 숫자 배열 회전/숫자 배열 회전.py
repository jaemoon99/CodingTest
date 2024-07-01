import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();

            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int[][] matrix90 = rotateMatrix(matrix, N);
            int[][] matrix180 = rotateMatrix(matrix90, N);
            int[][] matrix270 = rotateMatrix(matrix180, N);

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix90[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(matrix180[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(matrix270[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static int[][] rotateMatrix(int[][] matrix, int N) {
        int[][] newMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            int num = N;
            for (int j = 0; j < N; j++) {
                newMatrix[i][j] = matrix[--num][i];
            }
        }
        return newMatrix;
	}
}