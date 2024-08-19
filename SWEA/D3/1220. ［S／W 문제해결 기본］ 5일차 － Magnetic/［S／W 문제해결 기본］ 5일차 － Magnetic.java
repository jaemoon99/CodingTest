import java.util.Scanner;
import java.util.Stack;

public class Solution {

	static int n;
	static int[][] map;
	static int result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			result = 0;
			for (int i = 0; i < n; i++) {
				func(0, i);
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void func(int x, int y) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			if (map[i][y] == 0) {
				continue;
			}
			
			if (stack.isEmpty()) {
				stack.push(map[i][y]);
			} else {
				if (stack.peek() == 1 && map[i][y] == 2) {
					result++;
					stack.clear();
				} else {
					stack.push(map[i][y]);
				}
			}
			
		}
	}
}
