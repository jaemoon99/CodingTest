import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		List<int[]>[] dp = new ArrayList[41];
		
		for (int i = 0; i < 41; i++) {
		    dp[i] = new ArrayList<>();
		}
		
		dp[0].add(new int[] {1, 0});
		dp[1].add(new int[] {0, 1});
		
		for (int i = 2; i < 41; i++) {
			int[] prefix1 = dp[i - 1].get(0);
			int[] prefix2 = dp[i - 2].get(0);
			
			dp[i].add(new int[] {prefix1[0] + prefix2[0], prefix1[1] + prefix2[1]});
		}
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			int[] find = dp[n].get(0);
			
			System.out.println(find[0] + " " + find[1]);
		}
		
		sc.close();
	}

}
