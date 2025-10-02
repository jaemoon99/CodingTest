import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] str1 = sc.nextLine().split("");
		String[] str2 = sc.nextLine().split("");
		String[] str3 = sc.nextLine().split("");
		
		sc.close();
		
		int[][][] dp = new int[str1.length + 1][str2.length + 1][str3.length + 1];
		
		int result = 0;
		for (int i = 1; i < str1.length + 1; i++) {
			for (int j = 1; j < str2.length + 1; j++) {
				for (int k = 1; k < str3.length + 1; k++) {
					if (str1[i - 1].equals(str2[j - 1]) && str2[j - 1].equals(str3[k - 1])) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		
		System.out.println(dp[str1.length][str2.length][str3.length]);
	}

}
