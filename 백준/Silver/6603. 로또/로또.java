import java.util.Scanner;

public class Main {
	
	static int k;
	static int[] arr, check;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			k = sc.nextInt();
			
			if (k == 0) {
				break;
			}
			
			arr = new int[k];
			check = new int[k];
			
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			
			com(0, 0);
            System.out.println();
			
		}
		
		sc.close();
	}
	
	public static void com(int idx, int cnt) {
		
		if (cnt == 6) {
			for (int i = 0; i < k; i++) {
				if (check[i] == 1) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i < k; i++) {
			check[i] = 1;
			com(i + 1, cnt + 1);
			check[i] = 0;
		}
		
	}
}
