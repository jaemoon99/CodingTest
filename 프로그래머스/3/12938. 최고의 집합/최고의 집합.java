import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (s < n) {
            return new int[] {-1};
        }
        
        int[] answer = new int[n];
        
        if (s == n) {
            Arrays.fill(answer, 1);
            return answer;
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }
        
        for (int i = n - 1; i > n - s % n - 1; i--) {
            answer[i] += 1;
        }
        
        return answer;
    }
}