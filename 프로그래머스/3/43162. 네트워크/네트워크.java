import java.util.*;

class Solution {

	static int v[];

	public int solution(int n, int[][] computers) {
		int answer = 0;

		v = new int[n];

		for (int i = 0; i < n; i++) {
			if (v[i] == 0) {
				bfs(i, n, computers);
				answer++;
			}
		}

		return answer;
	}

	public void bfs(int num, int n, int[][] computers) {
		Deque<Integer> dq = new ArrayDeque<>();

		dq.add(num);
		v[num] = 1;

		while (!dq.isEmpty()) {
			int poll = dq.poll();
			for (int i = 0; i < n; i++) {
				if (v[i] == 0 && computers[poll][i] == 1) {
					dq.add(i);
					v[poll] = 1;
				}
			}
		}
	}
}