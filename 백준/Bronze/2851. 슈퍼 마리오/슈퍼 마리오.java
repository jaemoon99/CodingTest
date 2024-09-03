import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		int result = 0;
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			if (total + num > 100) {
				if (total + num  - 100 <= 100 - total) {
					result = total + num;
				} else if (total + num - 100 > 100 - total) {
					result = total;
				}
				break;
			} else {
				total += num;
				result = total;
			}
			
		}
		
		System.out.println(result);
	}
}
