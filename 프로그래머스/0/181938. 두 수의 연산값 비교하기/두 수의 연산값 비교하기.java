class Solution {
    public int solution(int a, int b) {
        int sum = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int mul = 2 * a * b;
        
        return Math.max(sum, mul);
        // return sum > mul ? sum : mul;
    }
}