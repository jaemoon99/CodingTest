class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        
        for (int num : num_list) {
            sum += num;
            mul *= num;
        }
        
        if (sum * sum > mul) {
            return 1;
        }
        
        return 0;
    }
}