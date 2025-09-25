import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
	        int[][] dist = new int[n + 1][n + 1];
	        for (int i = 1; i <= n; i++) {
	            Arrays.fill(dist[i], 999_999_999);
	            dist[i][i] = 0;
	        }
			
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				dist[a][b] = c;
				dist[b][a] = c;
			}
			
			int k = sc.nextInt();
			List<Integer> ks = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				ks.add(sc.nextInt());
			}
			
			for (int l = 1; l <= n; l++) {
	            for (int i = 1; i <= n; i++) {
	                for (int j = 1; j <= n; j++) {
	                    if (dist[i][j] > dist[i][l] + dist[l][j]) {
	                        dist[i][j] = dist[i][l] + dist[l][j];
	                    }
	                }
	            }
	        }
			
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					System.out.print(dist[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			int roomNumber = 0;
			int totalDist = 999_999_999;
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				for (int num : ks) {
					sum += dist[num][i];						
				}
				
				if (totalDist > sum) {
					roomNumber = i;
					totalDist = sum;
				}
				
				if (totalDist == sum) {
					if (roomNumber > i) {
						roomNumber = i;
					}
				}
			}
			
			System.out.println(roomNumber);
		}
		
		sc.close();
	}

}
