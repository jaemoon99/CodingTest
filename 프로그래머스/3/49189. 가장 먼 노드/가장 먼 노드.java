import java.util.*;

class Solution {
	public int solution(int n, int[][] edge) {
		int answer = 0;

		List<Integer>[] lst = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			lst[i] = new ArrayList<>();
		}

		for (int i = 0; i < edge.length; i++) {
			for (int j = 0; j < edge[0].length; j++) {
				lst[edge[i][0]].add(edge[i][1]);
				lst[edge[i][1]].add(edge[i][0]);
			}
		}

		int[] v = new int[n + 1];
		bfs(1, n, lst, v);
		
		Arrays.sort(v);
		for (int i = 0; i < n + 1; i++) {
			if (v[n] == v[i]) {
				answer++;
			}
		}

		return answer;
	}

	public void bfs(int num, int n, List<Integer>[] lst, int[] v){
		Deque<Integer> dq = new ArrayDeque<>();

		dq.add(num);
		v[num] = 1;

		while(!dq.isEmpty()) {
			int poll = dq.poll();

			for (int i = 0; i < lst[poll].size(); i++) {
				if (v[lst[poll].get(i)] == 0) {
					v[lst[poll].get(i)] = v[poll] + 1;
					dq.add(lst[poll].get(i));
				}
			}
		}
	}
}