import java.util.*;

class Solution {
	public int solution(int[] queue1, int[] queue2) {

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0L;
        long sum2 = 0L;
        
        for (int e : queue1) {
            q1.add(e);
            sum1 += e;
        }
        
        for (int e : queue2) {
            q2.add(e);
            sum2 += e;
        }
        
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        int cnt = 0;
        int limit = (queue1.length + queue2.length) * 2;
        while (sum1 != sum2 && cnt < limit) {
            
            if (sum1 > sum2) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
            } else if (sum2 > sum1) {
                int poll = q2.poll();
                sum2 -= poll;
                sum1 += poll;
                q1.add(poll);
            }
            
            cnt++;
        }
        
        if (sum1 == sum2) {
            return cnt;
        }

        return -1;
    }
}