import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

	static int h, w, cnt, result, map[][], v[][];
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int x1 = sc.nextInt() + 100;
			int y1 = sc.nextInt() + 100;
			int x2 = sc.nextInt() + 100;
			int y2 = sc.nextInt() + 100;

			result = Integer.MAX_VALUE;
			map = new int[201][201];
			
			map[x1][y1] = 1;
			map[x2][y2] = 2;
			
			Node node1 = new Node(x1, y1, 1);
			Node node2 = new Node(x1, y1, 2);
			
			v = new int[201][201];
			v[x1][y1] = 1;
			bfs(node1);
			v = new int[201][201];
			v[x1][y1] = 1;
			bfs(node2);
			
			System.out.println("#" + tc + " " + (result - 1));
		}
	}
	
	static void bfs(Node node) {
		Deque<Node> q = new ArrayDeque<>();
		q.offer(node);
		cnt = 0;
		while (!q.isEmpty()) {
			Node poll = q.poll();
			
			
			if (map[poll.x][poll.y] == 2) {
				if (result > v[poll.x][poll.y]) {
					result = v[poll.x][poll.y];
				}
				return;
			}
			
			if (poll.flag == 1) {
				for (int i = 0; i < 2; i++) {
					int nx = poll.x + dx[i];
					int ny = poll.y + dy[i];
					
					if (201 > nx && nx >= 0 && 201 > ny && ny >= 0 && v[nx][ny] == 0) {
						q.offer(new Node(nx, ny, 2));
						v[nx][ny] = v[poll.x][poll.y] + 1;
					}
				}
			} else {
				for (int i = 2; i < 4; i++) {
					int nx = poll.x + dx[i];
					int ny = poll.y + dy[i];
					
					if (201 > nx && nx >= 0 && 201 > ny && ny >= 0 && v[nx][ny] == 0) {
						q.offer(new Node(nx, ny, 1));
						v[nx][ny] = v[poll.x][poll.y] + 1;
					}
				}
			}
		}
	}
	
	static class Node {
		int x, y, flag;
		
		public Node(int x, int y, int flag) {
			this.x = x;
			this.y = y;
			this.flag = flag;
		}
	}
}
