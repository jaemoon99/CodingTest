import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		sc.close();
		
		int minNum = 999_999_999;
		int maxNum = 0;
		for (int i = 1; i <= num1 * num2; i++) {
			if (num1 % i == 0 && num2 % i == 0 && i > maxNum) {
				maxNum = i;
			}
			
			if (i % num1 == 0 && i % num2 == 0 && i < minNum) {
				minNum = i;
			}
		}
		
		System.out.println(maxNum);
		System.out.println(minNum);
		
	}

}