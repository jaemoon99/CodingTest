import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}
		
		int maxSum = 0;
		int maxCnt = 0;
		for (int i = 1; i <= n - x + 1; i++) {
			int sum = arr[i + x - 1] - arr[i - 1];
			
			if (sum > maxSum) {
				maxSum = sum;
				maxCnt = 0;
			}
			
			if (sum == maxSum) {
				maxCnt += 1;
			}
		}
		
		if (maxSum == 0) {
			System.out.println("SAD");
 		} else {
 			System.out.println(maxSum);
 			System.out.println(maxCnt);
 		}
		
		sc.close();
	}

}
