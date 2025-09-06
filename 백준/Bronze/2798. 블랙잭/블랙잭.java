import java.util.Scanner;

public class Main {
	
	static int n, m, result = 0, cards[], check[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		cards = new int[n];
		check = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}
		
		sc.close();
		
		com(0, 0);
		
		System.out.println(result);
	}

	static void com(int idx, int cnt) {
		if (cnt == 3) {
			
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (check[i] == 1) {
					sum += cards[i];
				}
			}
			
			if (m >= sum && sum > result) {
				result = sum;
			}
			
			return;
		}
		
		for (int i = idx; i < n; i++) {
			check[i] = 1;
			com(i + 1, cnt + 1);
			check[i] = 0;
		}
	}
}
