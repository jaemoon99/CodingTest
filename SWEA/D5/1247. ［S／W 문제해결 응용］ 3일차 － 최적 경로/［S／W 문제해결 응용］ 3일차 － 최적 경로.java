import java.util.Scanner;

public class Solution {

	static int n, companyX, companyY, homeX, homeY, result, map[][];
	static boolean[] v;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			
			n = sc.nextInt();
			
			companyX = sc.nextInt();
			companyY = sc.nextInt();

			homeX = sc.nextInt();
			homeY = sc.nextInt();
			
			map = new int[n][2];
			for (int i = 0; i < n; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
			v = new boolean[n];
			result = 999_999_999;

			permutation(0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void permutation(int cnt, int sum) {
		
		if (cnt == n) {
			sum = sum + cal(homeX, homeY, companyX, companyY);
			if (result > sum) {
				result = sum;
			}
			return;
		}
		
		
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				
				int tempX = companyX;
				int tempY = companyY;
				
				int d = cal(map[i][0], map[i][1], companyX, companyY);
				
				companyX = map[i][0];
				companyY = map[i][1];
				
				permutation(cnt + 1, sum + d);				
				
				v[i] = false;
				
				companyX = tempX;
				companyY = tempY;
			}
		}
	}
	
	static int cal(int sx, int sy, int ex, int ey) {
		return Math.abs(sx - ex) + Math.abs(sy - ey);
	}
}
