class Solution {
    public int solution(int[] num_list) {
        int answer = (num_list.length >= 11 ? 0 : 1);
        
        if (answer == 0) {
            for (int num : num_list) {
                answer += num;
            }
        } else {
            for (int num : num_list) {
            answer *= num;
            }
        }
        
        
        return answer;
    }
}