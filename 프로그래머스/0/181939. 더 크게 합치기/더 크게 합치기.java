class Solution {
    public int solution(int a, int b) {
        
        if (Integer.parseInt(a + "" + b) >= Integer.parseInt(b + "" + a)) {
            return Integer.parseInt(a + "" + b);
        }
        return Integer.parseInt(b + "" + a);
    }
}