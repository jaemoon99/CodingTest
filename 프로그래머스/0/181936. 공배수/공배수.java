class Solution {
    public int solution(int number, int n, int m) {
        // if (number % n == 0 && number % m == 0) {
        //     return 1;
        // }
        return (number % n == 0 && number % m == 0 ? 1 : 0);
    }
}