import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		
		sc.close();
		
		Arrays.sort(arr);
		
		long result = 0;
		for (int i = 0; i < n; i++) {
			
			int s = 0, e = n - 1;
			
			while (s < e) {

				if (e - s == 1 && (i == s || i == e)) {
					break;
				}
				
				if (s == i) {
					s++;
					continue;
				}
				
				if (e == i) {
					e--;
					continue;
				}
				
				if (arr[s] + arr[e] == arr[i]) {
					result++;
					break;
				}
				
				if (arr[s] + arr[e] < arr[i]) {
					s++;
				}
				
				if (arr[s] + arr[e] > arr[i]) {
					e--;
				}
			}
		}
		
		System.out.println(result);
	}
}
