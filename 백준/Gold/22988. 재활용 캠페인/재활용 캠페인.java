import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long x = sc.nextLong();
		
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		
		sc.close();
		
		Arrays.sort(arr);
		
		int s = 0, e = n - 1, cnt = 0, remain = 0;
		long half = (x + 1) / 2;
		
		while (s <= e) {
			
			if (arr[e] >= x) {
				cnt++;
				e--;
				continue;
			}
			
			if (s == e) {
				remain++;
				break;
			}
			
			if (arr[s] + arr[e] >= half) {
				cnt++;
				s++;
				e--;
			} else {
				s++;
				remain++;
			}
		}
		
		System.out.println(cnt + remain / 3);
	}
}
