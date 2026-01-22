import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = (i == n - 1) ? -1 : i + 1;
        }

        Deque<int[]> stack = new ArrayDeque<>();
        int cur = k;

        for (String c : cmd) {
            char op = c.charAt(0);

            if (op == 'U' || op == 'D') {
                int cnt = Integer.parseInt(c.substring(2));
                for (int i = 0; i < cnt; i++) {
                    cur = (op == 'U') ? prev[cur] : next[cur];
                }
            } else if (op == 'C') {
                int p = prev[cur];
                int nIdx = next[cur];

                stack.push(new int[]{cur, p, nIdx});
                deleted[cur] = true;

                if (p != -1) {
                    next[p] = nIdx;
                }
                
                if (nIdx != -1) {
                    prev[nIdx] = p;
                }

                cur = (nIdx != -1) ? nIdx : p;
            } else {
                int[] rec = stack.pop();
                int idx = rec[0];
                int p = rec[1];
                int nIdx = rec[2];

                deleted[idx] = false;

                if (p != -1) {
                    next[p] = idx;
                }
                
                if (nIdx != -1) {
                    prev[nIdx] = idx;
                }

                prev[idx] = p;
                next[idx] = nIdx;
            }
        }

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(deleted[i] ? 'X' : 'O');
        }
        
        return sb.toString();
    }
}