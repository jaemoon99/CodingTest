class Solution {
    public int solution(int num1, int num2) {
        double sub = (double) num1 / num2;
        sub *= 1000;
        int answer = (int) sub;
        return answer;
    }
}