class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long dp0 = 0;
        long dp1 = 0;

        for (int i = 0; i < sequence.length; i++) {
            long v0 = (i % 2 == 0) ? sequence[i] : -sequence[i];
            long v1 = -v0;

            dp0 = Math.max(v0, dp0 + v0);
            dp1 = Math.max(v1, dp1 + v1);

            answer = Math.max(answer, Math.max(dp0, dp1));
        }

        return answer;
    }
}