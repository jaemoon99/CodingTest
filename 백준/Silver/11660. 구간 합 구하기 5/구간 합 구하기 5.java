import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		int[][] arr = new int[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == 0) {
					arr[i][j] = sc.nextInt();
				} else {
					arr[i][j] = arr[i][j - 1] + sc.nextInt();
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			
			int x1 = sc.nextInt() - 1;
			int y1 = sc.nextInt();
			int x2 = sc.nextInt() - 1;
			int y2 = sc.nextInt();
			
			int result = 0;
			for (int j = x1; j <= x2; j++) {
				result += arr[j][y2] - arr[j][y1 - 1];
			}
			
			System.out.println(result);
		}
		
		sc.close();
	}
}