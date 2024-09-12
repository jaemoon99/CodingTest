import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] check = new boolean[n][n];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			check[a][b] = true;
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(check[i][k] && check[k][j]) {
						check[i][j] = true;
					}
				}
			}
		}
		
		int[] cnt = new int[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
                if(check[i][j] || check[j][i]) {
					cnt[i] ++;
				}
			}
		}
		
		int result = 0;
		for(int num : cnt) {
			if(num == n - 1) result++;
		}
		System.out.println(result);
		
	}
}