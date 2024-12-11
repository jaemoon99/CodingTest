import java.util.Scanner;

public class Main {
	
	static int n, m, sel[];
	static StringBuilder sb;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		sel = new int[m];
		
		per(1, 0);
		
		System.out.println(sb);
		
		sc.close();
	}
	
	static void per(int start, int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= n; i++) {
			sel[cnt] = i;
			per(i, cnt + 1);
		}
	}
}