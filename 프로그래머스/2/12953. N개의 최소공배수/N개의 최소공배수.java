class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0] * arr[1] / gcd(arr[0], arr[1]);
        
        for (int i = 1; i < arr.length; i++) {

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