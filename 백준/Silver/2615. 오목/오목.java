import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int map[][], resColor = 0, resX = 0, resY = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		map = new int[19][19];
		ArrayList<int[]> spots = new ArrayList<>();
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0) {
					spots.add(new int[] {i, j});
				}
			}
		}
		
		for (int[] spot : spots) {
			func(spot[0], spot[1], map[spot[0]][spot[1]]);
			if (resColor != 0) {
				break;
			}
		}
		System.out.println(resColor);
		if (resColor != 0) {
			System.out.println(resX + " " + resY);
		}
	}
	
	static int[] dx = new int[] {1, 0, -1, 1};
	static int[] dy = new int[] {0, 1, 1, 1};
	
	static void func(int x, int y, int color) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			int cnt = 1;
			for (int j = 0; j < 19; j++) {
				nx += dx[i];
				ny += dy[i];
				
				if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || map[nx][ny] != color) {
					break;
				}
				
				cnt++;
			}

			if (cnt == 5) {
				int xx = x - dx[i];
				int yy = y - dy[i];
				if (xx >= 0 && xx < 19 && yy >= 0 && yy < 19 && map[xx][yy] != color){
					resColor = color;
					resX = x + 1;
					resY = y + 1;
					return;
				} else if (xx < 0 || xx >= 19 || yy < 0 || yy >= 19) {
					resColor = color;
					resX = x + 1;
					resY = y + 1;
					return;
				}
			}
		}
	}
}

