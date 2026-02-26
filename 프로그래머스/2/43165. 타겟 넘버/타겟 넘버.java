class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(0, 0, target, numbers);

        return answer;
    }


    private int dfs(int sum, int idx, int target, int[] numbers) {

        if (idx == numbers.length) {
            
            if (target == sum) {
                return 1;
            }
            
            return 0;
        }

        return dfs(sum + numbers[idx], idx + 1, target, numbers) + dfs(sum - numbers[idx], idx + 1, target, numbers);
    }
}