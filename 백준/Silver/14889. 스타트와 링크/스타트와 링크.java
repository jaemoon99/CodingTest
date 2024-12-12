import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int n, k, map[][], sel[], v[];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		sel = new int[n];
		v = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		per(0, 0);
		
		System.out.println(result);
		
		sc.close();
	}
	
	static void per(int start, int cnt) {
		if (cnt == n / 2) {
			List<Integer> t = new ArrayList<>();
			List<Integer> f = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (v[i] == 1) {
					t.add(i);
				} else {
					f.add(i);
				}
			}
			
			int tTotal = 0;
			int fTotal = 0;
			for (int i = 0; i < n / 2; i++) {
				for (int j = i + 1; j < n / 2; j++) {
					tTotal += map[t.get(i)][t.get(j)];
					tTotal += map[t.get(j)][t.get(i)];
				}
			}
			
			for (int i = 0; i < n / 2; i++) {
				for (int j = i + 1; j < n / 2; j++) {
					fTotal += map[f.get(i)][f.get(j)];
					fTotal += map[f.get(j)][f.get(i)];
				}
			}
			
			result = Math.min(result, Math.abs(tTotal - fTotal));
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (v[i] == 0) {
				v[i] = 1;
				per(i + 1, cnt + 1);
				v[i] = 0;
			}
		}
	}
}