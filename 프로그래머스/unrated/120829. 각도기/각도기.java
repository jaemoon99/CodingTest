class Solution {
    public int solution(int angle) {
        if (90 > angle && angle > 0) {
            return 1;
        } else if (angle == 90) {
            return 2;
        } else if (180 > angle && angle > 90) {
            return 3;
        } else {
            return 4;
        }
    }
}