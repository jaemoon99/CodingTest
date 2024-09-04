import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int firNum = 0;
		int secNum = 0;
		int firMax = 0;
		int secMax = 0;
		int[] l = new int[L + 1];
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			if (end - start > firMax) {
				firNum = i + 1;
				firMax = end - start;
			}
			
			int cnt = 0;
			for (int j = start; j <= end; j++) {
				if (l[j] == 0) {
					l[j] = 1;
					cnt++;
				}
			}
			
			if (cnt > secMax) {
				secNum = i + 1;
				secMax = cnt;
			}
		}
		
		System.out.println(firNum);
		System.out.println(secNum);
	}
}
