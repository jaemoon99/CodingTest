class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            
            if (i % 2 == 0 && n % 2 == 0) {
                answer += Math.pow(i, 2);
            } else if (i % 2 == 1 && n % 2 == 1) {
                answer += i;
            }
        }
        
        return answer;
    }
}