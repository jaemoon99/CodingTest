import java.util.Scanner;

public class Main {
	
	static int n, k, result, weight[], sel[], v[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		weight = new int[n];
		sel = new int[n];
		v = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
		}
		
		per(0);
		
		System.out.println(result);
		sc.close();
	}
	
	static void per(int cnt) {
		if (cnt == n) {
			int total = 500;
			for (int num : sel) {
				total += num - k;
				if (total < 500) {
					return;
				}
			}
			result++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (v[i] == 0) {
				v[i] = 1;
				sel[cnt] = weight[i];
				per(cnt + 1);
				v[i] = 0;
			}
		}
	}
}