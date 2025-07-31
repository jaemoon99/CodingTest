import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}
		
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= n - k + 1; i++) {
			int sum = arr[i + k - 1] - arr[i - 1];
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
		sc.close();
	}
}