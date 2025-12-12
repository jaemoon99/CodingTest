class Solution {
	public int solution(int[][] board, int[][] skill) {

		int[][] memo = new int[board.length + 1][board[0].length + 1];

		memo(skill, memo);
		calWidth(memo);
		calHeight(memo);

		return sum(board, memo);
	}

	public void memo(int[][] skill, int[][] memo) {
		for (int[] s : skill) {
			int val = s[0] == 1 ? -s[5] : s[5];

			memo[s[1]][s[2]] += val;
			memo[s[1]][s[4] + 1] -= val;
			memo[s[3] + 1][s[2]] -= val;
			memo[s[3] + 1][s[4] + 1] += val;

		}
	}

	public void calWidth(int[][] memo) {
		for (int i = 0; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {
				memo[i][j] = memo[i][j] + memo[i][j - 1];
			}
		}
	}

	public void calHeight(int[][] memo) {
		for (int i = 0; i < memo[0].length; i++) {
			for (int j = 1; j < memo.length; j++) {
				memo[j][i] = memo[j][i] + memo[j - 1][i];
			}
		}
	}

	public int sum(int[][] board, int[][] memo) {
		int cnt = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] + memo[i][j] > 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}