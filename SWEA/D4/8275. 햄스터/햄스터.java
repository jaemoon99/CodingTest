import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt(); // 우리 수
            int x = sc.nextInt(); // 한 칸의 최대 햄스터 수
            int m = sc.nextInt(); // 명령 수
            
            int[] map = new int[n + 1]; // 각 칸에 배정된 햄스터 수
            int[] v = new int[n + 1]; // 방문 여부
            List<int[]> list = new ArrayList<>();
            
            // 명령 입력 받기
            for (int i = 0; i < m; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int s = sc.nextInt();
                list.add(new int[] {l, r, s});
            }
            
            int[] arr = new int[n];
            boolean result = false;
            int[] answer = new int[n];
            for (int i = 0; i < Math.pow(x + 1, n); i++) {
            	int temp = i;
            	for (int j = 0; j < n; j++) {
            		arr[j] = temp % (x + 1);
            		temp /= x + 1;
            	}
            	
            	boolean check = true;
            	for (int j = 0; j < list.size(); j++) {
            		int[] subArr = list.get(j);
            		int sum = 0;
            		for(int k = subArr[0] - 1; k < subArr[1]; k++) {
            			sum += arr[k];
            		}
            		
            		if (sum != subArr[2]) {
            			check = false;
            			break;
            		}
            	}
            	
            	if (check) {
            		for (int j = 0; j < n; j++) {
            			answer[j] = arr[j];
            		}
            		result = true;
            	} else {
            		continue;
            	}
            }
            
            System.out.print("#" + tc + " ");
            if (result) {
            	for (int i = 0; i < n; i++) {
            		System.out.print(answer[i] + " ");
            	}
            	System.out.println();
            } else {
            	System.out.println(-1);
            }
        }
    }
}
