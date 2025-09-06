import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			int num = sc.nextInt();
			
			if (num == 0) {
				sc.close();
				return;
			}
			
			String numToStr = num + "";
			
			String reverse = "";
			for (int i = numToStr.length() - 1; i >= 0; i--) {
				reverse += numToStr.charAt(i) + "";
			}
			
			if (numToStr.equals(reverse)) {
				System.out.println("yes");
				continue;
			}
			
			System.out.println("no");
		}
	}
}