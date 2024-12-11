import java.util.Scanner;

public class Main {
	
	static int n, max, map[], sel[], v[];
	static StringBuilder sb;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		n = sc.nextInt();
		
		map = new int[n];
		sel = new int[n];
		
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextInt();
		}
		
		v = new int[n];
		
		per(0);
		
		System.out.println(max);
		
		sc.close();
	}
	
	static void per(int cnt) {
		if (cnt == n) {
			int result = cal();
			max = Math.max(max, result);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (v[i] == 0) {
				v[i] = 1;
				sel[cnt] = map[i];
				per(cnt + 1);
				v[i] = 0;
			}
		}
	}
	
	static int cal() {
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			result += Math.abs(sel[i] - sel[i + 1]);
		}
		return result;
	}
}