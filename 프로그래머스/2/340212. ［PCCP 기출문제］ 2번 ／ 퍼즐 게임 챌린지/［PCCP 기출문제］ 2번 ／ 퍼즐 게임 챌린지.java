import java.util.Arrays;

class Solution {
	public int solution(int[] diffs, int[] times, long limit) {
		int start = 1;
		int end = Arrays.stream(diffs).max().getAsInt();

		while (start < end) {
			int level = (start + end) / 2;
			if (check(diffs, times, limit, level)) {
				end = level;
			} else {
                start = level + 1;
            }
		}
        
		return start;
	}

	public boolean check(int[] diffs, int[] times, long limit, int level) {
		long sum = 0;
		for (int i = 0; i < diffs.length; i++) {

			if (level >= diffs[i]) {
				sum += times[i];
				continue;
			}

			sum += ((long) (diffs[i] - level) * (times[i - 1] + times[i]) + times[i]);
		}

		return sum <= limit;
	}
}