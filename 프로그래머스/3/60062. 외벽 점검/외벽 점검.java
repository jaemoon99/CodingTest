import java.util.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int w = weak.length;
        
        int[] weak2 = new int[w * 2];
        for (int i = 0; i < w; i++) {
            weak2[i] = weak[i];
            weak2[i + w] = weak[i] + n;
        }

        Integer[] d = new Integer[dist.length];
        for (int i = 0; i < dist.length; i++) {
            d[i] = dist[i];
        }
        
        Arrays.sort(d, Collections.reverseOrder());

        int best = Integer.MAX_VALUE;

        for (int start = 0; start < w; start++) {
            best = Math.min(best, dfs(start, start, 0, w, weak2, d, new boolean[d.length], best));
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }

    private int dfs(int start, int idx, int cnt, int w, int[] weak2, Integer[] d, boolean[] used, int best) {
        if (cnt >= best) {
            return best;
        }
        
        if (idx >= start + w) {
            return Math.min(best, cnt);
        }

        for (int i = 0; i < d.length; i++) {
            if (used[i]) {
                continue;
            }
            
            used[i] = true;

            int limit = weak2[idx] + d[i];
            int nextIdx = idx;
            int end = start + w;
            while (nextIdx < end && weak2[nextIdx] <= limit) {
                nextIdx++;
            }

            best = dfs(start, nextIdx, cnt + 1, w, weak2, d, used, best);

            used[i] = false;
        }
        
        return best;
    }
}