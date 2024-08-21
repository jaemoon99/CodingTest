import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		int result = -1;
		for(int i = N / 5; i >= 0; i--) {
			int cnt = i;
			int sub = N - i * 5;
			
			if (sub % 3 == 0) {
				cnt += sub / 3;
				result = cnt;
				break;
			}
		}
		
		System.out.println(result);
	}
}
