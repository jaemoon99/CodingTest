import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] map = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			map[i] = num + map[i - 1];
		}
		
		
		for (int i = 0; i < m; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(map[k] - map[j - 1]);
		}
	}	
}