import java.util.*;

class Solution {
    static class Node {
        long first;   // t
        long second;  // next finish time
        Node(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public long solution(int n, int[] times) {
        double workload = 0.0;
        for (int t : times) workload += 1.0 / t;

        long lowerBound = (long) (n / workload);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.second != b.second) return Long.compare(a.second, b.second);
            return Long.compare(a.first, b.first);
        });

        long cnt = 0;
        for (int t : times) {
            long tt = t;
            cnt += (lowerBound / tt);
            long nextFinish = (lowerBound / tt + 1) * tt;
            pq.offer(new Node(tt, nextFinish));
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            answer = cur.second;
            cur.second += cur.first;

            if (++cnt == n) break;

            pq.offer(cur);
        }

        return answer;
    }
}