import java.util.Scanner;

public class Main {
	
	static int n, m, sel[], v[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		sel = new int[m];
		v = new int[n];
		
		com(0);
		
		sc.close();
	}
	
	static void com(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (v[i] == 0) {
				v[i] = 1;
				sel[cnt] = i + 1;
				com(cnt + 1);
				v[i] = 0;
			}
		}
	}
}