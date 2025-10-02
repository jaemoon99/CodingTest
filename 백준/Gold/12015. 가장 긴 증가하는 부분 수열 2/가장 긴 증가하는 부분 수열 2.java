import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int len = 0;
		for (int i = 0; i < n; i++) {
		    int num = sc.nextInt();

		    int pos = Arrays.binarySearch(arr, 0, len, num);
		    if (pos < 0) {
		    	pos = -pos - 1;
		    }

		    arr[pos] = num;
		    if (pos == len) {
		    	len++;
		    }
		}
		
		sc.close();
		
		System.out.println(len);
	}
}
