import java.util.Scanner;

public class Solution {

	static int[][] map;
	static int[][] v;
	static int result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			
			map = new int[100][100];
			v = new int[100][100];
			
			int pointX = 0;
			int pointY = 0;
			
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k <100; k++) {
					map[j][k] = sc.nextInt();
					if (map[j][k] == 2) {
						pointX = j;
						pointY = k;
					}
				}
			}
			
			v[pointX][pointY] = 1;
			func(pointX, pointY);
			System.out.println("#" + num + " " + result);
		}
	}
	
	static void func(int x, int y) {
		if (x == 0) {
			result = y;
			return;
		}
		
		int[] dx = {0, 0, -1};
		int[] dy = {-1, 1, 0};
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || map[nx][ny] == 0 || v[nx][ny] == 1) {
				continue;
			}
			
			v[nx][ny] = 1;
			func(nx, ny);
			return;
		}
		
	}
}
