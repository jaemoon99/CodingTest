import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	
	static int[][] map;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc < 11; tc++) {
			int num = sc.nextInt();
			map = new int[16][16];
			
			int startX = 0;
			int startY = 0;
			
			for (int i = 0; i < 16; i++) {
				String input = sc.next();
				for (int j = 0; j < input.length(); j++) {
					map[i][j] = input.charAt(j) - '0';
					if (map[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			
			System.out.println("#" + tc + " " + bfs(startX, startY));
		}
	}
	
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy	= new int[]	{0, 0, -1, 1};

	private static int bfs(int x, int y) {
		int check = 0;
		
		Deque<int[]> q = new ArrayDeque<>();
		map[x][y] = 1;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if (nx >= 16 || nx < 0 || ny >= 16 || ny < 0 || map[nx][ny] == 1) {
					continue;
				}
				
				if (map[nx][ny] == 3) {
					check = 1;
					break;
				}
				
				map[nx][ny] = 1;
				q.offer(new int[] {nx, ny});
			}
		}
		
		return check;
	}
}
