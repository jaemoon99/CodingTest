import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 0; tc < t; tc++) {
			
			int n = sc.nextInt();
			
			int[] price = new int[n];
			for (int i = 0; i < n; i++) {
				price[i] = sc.nextInt();
			}
			
			long result = 0;
			int maxValue = price[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				if (price[i] > maxValue) {
					maxValue = price[i];
				}
				
				if (maxValue > price[i]) {
					result += maxValue - price[i];
				}
			}
			
			System.out.println(result);
		}
		
		sc.close();
	}

}
