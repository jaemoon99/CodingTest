import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (s < n) {
            return new int[] {-1};
        }
        
        int[] answer = new int[n];
        
        Arrays.fill(answer, s / n);
        
        for (int i = n - 1; i > n - s % n - 1; i--) {
            answer[i] += 1;
        }
        
        return answer;
    }
}