class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;
        int start = 1;

        for (int s : stations) {
            int left = s - w;
            if (start < left) {
                int gap = left - start;
                answer += (gap + cover - 1) / cover;
            }
            start = s + w + 1;
        }

        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + cover - 1) / cover;
        }

        return answer;
    }
}