import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int cnt = 0;
			String result = "";
			int k = sc.nextInt();
			String[] strs = new String[k];
			for (int j = 0; j < k; j++) {
				strs[j] = sc.next();
			}
			
			point : for (int j = 0; j < k; j++) {
				for (int l = j + 1; l < k; l++) {
					String str = strs[j] + strs[l];
					String reverse = new StringBuffer(str).reverse().toString();
					if (str.equals(reverse)) {
						result = str;
						cnt++;
						break point;
					}
					
					str = strs[l] + strs[j];
					reverse = new StringBuffer(str).reverse().toString();
					if (str.equals(reverse)) {
						result = str;
						cnt++;
						break point;
					}
				}
			}
			System.out.println(cnt == 0 ? 0 : result);
		}
		
		sc.close();
    }
}