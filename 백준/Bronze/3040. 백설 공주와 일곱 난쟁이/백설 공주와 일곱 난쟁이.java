import java.util.Scanner;

public class Main {

	static int n, m, map[], v[];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		map = new int[9];
		v = new int[9];
		
		for (int i = 0; i < 9; i++) {
			map[i] = sc.nextInt();
		}
		
		subSet(0);
	}
	
	static void subSet(int cnt) {
		if (cnt == 9) {
			int sum = 0;
			int sCnt = 0;
			for (int i = 0; i < 9; i++) {
				if (v[i] == 1) {
					sum += map[i];
					sCnt++;
				}
			}
			if (sum == 100 && sCnt == 7)	{
				for (int i = 0; i < 9; i++) {
					if (v[i] == 1) {
						System.out.println(map[i] + " ");
					}
				}
				System.out.println();
			}
			return;
		}
		
		v[cnt] = 1;
		subSet(cnt + 1);
		v[cnt] = 0;
		subSet(cnt + 1);

	}
}