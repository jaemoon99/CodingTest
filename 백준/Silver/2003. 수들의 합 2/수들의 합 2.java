import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n =  sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] += sc.nextInt();
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			int sum = arr[i];
			if (sum == m) {
				result++;
			}
			for (int j = i + 1; j < n; j++) {
				sum += arr[j];
				if (sum == m) {
					result++;
				}
			}
		}

		System.out.println(result);

		sc.close();
	}
}
