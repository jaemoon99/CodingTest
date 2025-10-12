import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] time = new int[n];
		for (int i = 0; i < n; i++) {
			time[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(time);
		
		int sum = 0;
		int[] wait = new int[n];
		for (int i = 0; i < n; i++) {
			wait[i] = sum + time[i];
			sum += time[i];
		}
		
		System.out.println(Arrays.stream(wait).sum());
	}

}
