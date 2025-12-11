import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] r : routes) {
            if (camera < r[0]) {
                camera = r[1];
                answer++;
            }
        }

        return answer;
    }
}