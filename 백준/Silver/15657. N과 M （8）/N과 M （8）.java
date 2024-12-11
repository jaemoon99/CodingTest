import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m, map[], sel[];
	static StringBuilder sb;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n];
		sel = new int[m];
		
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextInt();
		}
		
		Arrays.sort(map);
		
		per(0, 0);
		
		System.out.println(sb.toString());
		
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
		
		for (int i = start; i < n; i++) {
			sel[cnt] = map[i];
			per(i, cnt + 1);
		}
	}
}