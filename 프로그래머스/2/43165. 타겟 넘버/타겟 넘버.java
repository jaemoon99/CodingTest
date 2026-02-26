class Solution {

    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(0, 0, target, numbers);

        return answer;
    }


    private void dfs(int sum, int idx, int target, int[] numbers) {

        if (idx == numbers.length) {
            
            if (target == sum) {
                answer++;            
            }
            
            return;
        }

        dfs(sum + numbers[idx], idx + 1, target, numbers);
        dfs(sum - numbers[idx], idx + 1, target, numbers);

    }
}