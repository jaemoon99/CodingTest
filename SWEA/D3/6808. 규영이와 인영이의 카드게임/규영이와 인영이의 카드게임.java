import java.util.Scanner;

public class Solution {

	static int[] gy;
	static int[] iy;
	static int win;
	static int lose;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			gy = new int[9];
			iy = new int[9];
			int[] sel = new int[9];
			boolean[] v = new boolean[9];
			
			for (int i = 0; i < 9; i++) {
				gy[i] = sc.nextInt();
			}
			
			int iyIdx = 0;
			for (int i = 1; i <= 18; i++) {
				int cnt = 0;
				for (int j = 0; j < 9; j++) {
					if (i == gy[j]) {
						cnt++;
					}
				}
				if (cnt == 0) {
					iy[iyIdx++] = i;
				}
			}
			
			win = 0;
			lose = 0;
			func(0, sel, v);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
	
	static void func(int cnt, int[] sel, boolean[] v) {
		if (cnt == 9) {
			int gyScore = 0;
            int iyScore = 0;

            for (int i = 0; i < 9; i++) {
                if (gy[i] > sel[i]) {
                    gyScore += gy[i] + sel[i];
                } else {
                    iyScore += gy[i] + sel[i];
                }
            }

            if (gyScore > iyScore) {
                win++;
            } else {
                lose++;
            }
            return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!v[i]) {
				sel[cnt] = iy[i];
				v[i] = true;
				func(cnt + 1, sel, v);
				v[i] = false;
			}
		}
	}
}
