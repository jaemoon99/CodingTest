import java.util.Scanner;

public class Main {
	
	static int n, m, sel[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		sel = new int[m];
		
		com(1, 0);
		
		sc.close();
	}
	
	static void com(int start, int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= n; i++) {
			sel[cnt] = i;
			com(i + 1, cnt + 1);
		}
	}
}