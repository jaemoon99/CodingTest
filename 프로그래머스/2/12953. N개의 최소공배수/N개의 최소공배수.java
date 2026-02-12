class Solution {
    public int solution(int[] arr) {
        int lcm = 0;
        for (int i = 1; i < arr.length; i++) {
            
            if (i == 1) {
                int gcd = gcd(arr[i-1], arr[i]);
                
                lcm = arr[i-1] * arr[i] / gcd;
                continue;
            }

            int gcd = gcd(lcm, arr[i]);
            lcm = lcm * arr[i] / gcd;
        }

        return lcm;
    }

    public static int gcd(int num1, int num2) {

        if (num2 == 0) {
            return num1;
        }

        return gcd(num2, num1%num2);
    }
}