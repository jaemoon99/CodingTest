class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        
        for (int num : num_list) {
            sum += num;
            mul *= num;
        }
        
        if (Math.pow(sum, 2) > mul) {
            return 1;
        }
        
        return 0;
    }
}