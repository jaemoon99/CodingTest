import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String input1 = sc.next();
			String input2 = sc.next();
		
			input1 = input1.replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0").replaceAll("[ADOPQR]", "1").replaceAll("B", "2");
			input2 = input2.replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0").replaceAll("[ADOPQR]", "1").replaceAll("B", "2");
			
	        StringBuilder sb = new StringBuilder();
	        sb.append("#" + tc + " ");
	        if (input1.equals(input2)) {
	        	sb.append("SAME");
	        } else {
	        	sb.append("DIFF");
	        }
	        
	        System.out.println(sb);
		}
		
        
	}
}
