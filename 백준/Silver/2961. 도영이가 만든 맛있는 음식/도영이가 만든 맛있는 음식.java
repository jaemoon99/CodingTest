import java.util.Scanner;

public class Main {

	static int N;
	static int result;
	static int[] sour;
	static int[] bitter;
	static boolean[] v;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		sour = new int[N];
		bitter = new int[N];
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		
		result = 999_999_999;
		func(0);
		System.out.println(Math.abs(result));
	}
	
	static void func(int cnt) {
		if (cnt == N) {
			int totalSour = 1;
			int totalBitter = 0;
			for (int i = 0; i < N; i++) {
				if (v[i] == true) {
					totalSour *= sour[i];
					totalBitter += bitter[i];
				}
			}
			int subResult = Math.abs(totalSour - totalBitter);
			if (totalSour != 1 && totalBitter != 0 && result > subResult) {
				result = subResult;
			}
			return;
		}
		
		v[cnt] = true;
		func(cnt + 1);
		v[cnt] = false;
		func(cnt + 1);
	}
}
