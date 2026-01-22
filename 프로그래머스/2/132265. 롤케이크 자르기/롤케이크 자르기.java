import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> rightCount = new HashMap<>();
        for (int t : topping) {
            rightCount.put(t, rightCount.getOrDefault(t, 0) + 1);
        }

        Set<Integer> leftSet = new HashSet<>();
        int rightKinds = rightCount.size();
        int answer = 0;

        for (int i = 0; i < topping.length - 1; i++) { // 마지막에서 자르면 오른쪽이 비니까 제외
            int t = topping[i];

            // 왼쪽에 추가
            leftSet.add(t);

            // 오른쪽에서 제거(개수 감소)
            rightCount.put(t, rightCount.get(t) - 1);
            if (rightCount.get(t) == 0) {
                rightCount.remove(t);
                rightKinds--;
            }

            // 비교
            if (leftSet.size() == rightKinds) {
                answer++;
            }
        }

        return answer;
    }
}