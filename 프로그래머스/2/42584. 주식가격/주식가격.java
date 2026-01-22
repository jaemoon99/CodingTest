import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && prices[dq.peekLast()] > prices[i]) {
                int t = dq.pollLast();
                answer[t] = i - t;
            }
            dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            int t = dq.pollLast();
            answer[t] = (n - 1) - t;
        }

        return answer;
    }
}