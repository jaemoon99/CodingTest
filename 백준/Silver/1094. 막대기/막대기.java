import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		String x = Integer.toBinaryString(X);
		
		int result = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '1') {
				result++;
			}
		}
		System.out.println(result);
	}
}
