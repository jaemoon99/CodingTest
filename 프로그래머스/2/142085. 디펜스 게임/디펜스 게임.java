import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (k >= enemy.length) {
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) {

            if (n >= e) {
                pq.add(e);
                n -= e;
            } else {
                if (k > 0) {
                    if (!pq.isEmpty() && pq.peek() > e) {
                        n += pq.poll();
                        n -= e;
                        pq.offer(e);
                    }
                    k--;
                } else {
                    break;
                }
            }

            answer++;
        }

        return answer;
    }
}