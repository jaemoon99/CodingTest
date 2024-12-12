import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[] strs = new String[n];
		
		for (int i = 0; i < n; i++) {
			strs[i] = sc.next();
		}
		
		StringBuilder sb = new StringBuilder();
		int result = 0;
		char[] dna = new char[] {'A', 'C', 'G', 'T'};
		for (int i = 0; i < m; i++) {
			int[] count = new int[4];
			
			for (int j = 0; j < n; j++) {
				char temp = strs[j].charAt(i);
				switch (temp) {
				case 'A':
					count[0]++;
					break;
				case 'C':
					count[1]++;
					break;
				case 'G':
					count[2]++;
					break;
				case 'T':
					count[3]++;
					break;
				}	
			}

			int maxValue = count[0];
			int maxIdx = 0;
			for (int j = 1; j < 4; j++) {
				if (count[j] > maxValue) {
					maxValue = count[j];
					maxIdx = j;
				}
			}
			
			sb.append(dna[maxIdx]);
			result += (n - maxValue);
		}
		
		sb.append("\n" + result);
		System.out.println(sb);
		sc.close();
    }
}