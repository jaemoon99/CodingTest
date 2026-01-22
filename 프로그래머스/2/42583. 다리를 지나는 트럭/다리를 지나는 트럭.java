import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.addLast(0);
        }

        int time = 0;
        int sum = 0;
        int idx = 0;

        while (idx < truck_weights.length) {
            time++;

            int out = bridge.pollFirst();
            sum -= out;

            int next = truck_weights[idx];
            if (sum + next <= weight) {
                bridge.addLast(next);
                sum += next;
                idx++;
            } else {
                bridge.addLast(0);
            }
        }

        return time + bridge_length;
    }
}