import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m, map[], sel[], v[];
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
		
		v = new int[n];
		
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
			
			if (i > start && map[i] == map[i - 1] && v[i - 1] == 0) {
                continue;
            }
			
			sel[cnt] = map[i];
			per(i, cnt + 1);
		}
	}
}