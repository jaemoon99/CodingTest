import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int N;
	static int startX, startY;
	static int result;
	static ArrayList<ArrayList<Integer>> map;
	static int[] home;
	static int[] sel;
	static boolean[] v;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			N = sc.nextInt();
			
			int[] company = new int[] {sc.nextInt(), sc.nextInt()};
			home = new int[] {sc.nextInt(), sc.nextInt()};
			map = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				map.add(new ArrayList<Integer>());
				map.get(i).add(sc.nextInt());
				map.get(i).add(sc.nextInt());
			}
			
			sel = new int[N];
			v = new boolean[N];
			result = 999_999_999;
			startX = company[0];
			startY = company[1];
			func(0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void func(int cnt, int sum) {
		
		
		if (cnt == N) {
			sum = sum + Math.abs(home[0] - startX) + Math.abs(home[1] - startY);
			if (result > sum) {
				result = sum;
			}
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[cnt] = i + 1;
				int tempX = startX;
				int tempY = startY;
				int d = Math.abs(map.get(i).get(0) - startX) + Math.abs(map.get(i).get(1) - startY);
				startX = map.get(i).get(0);
				startY = map.get(i).get(1);
				func(cnt + 1, sum + d);				
				v[i] = false;
				startX = tempX;
				startY = tempY;
			}
		}
	}
}
