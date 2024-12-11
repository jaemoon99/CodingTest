import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		boolean[][] check = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			check[num1][num2] = true;
			check[num2][num1] = true;
		}
		
		int result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (check[i][j]) {
					continue;
				}
				for (int k = j + 1; k <= n; k++) {
					if (!check[i][k] && !check[j][k] && !check[k][i] && !check[k][j]) {
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
		sc.close();
    }
}