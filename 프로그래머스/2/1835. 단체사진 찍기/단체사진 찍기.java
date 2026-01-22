import java.util.*;

class Solution {
    static final char[] PEOPLE = {'A','C','F','J','M','N','R','T'};
    static int answer;
    static int[] pos = new int[8];
    static boolean[] used = new boolean[8];
    static Map<Character, Integer> idx = new HashMap<>();
    static String[] cond;

    public int solution(int n, String[] data) {
        for (int i = 0; i < 8; i++) {
            idx.put(PEOPLE[i], i);
        }
        cond = data;
        answer = 0;
        Arrays.fill(used, false);

        dfs(0);
        return answer;
    }

    static void dfs(int depth) {
        if (depth == 8) {
            if (checkAll()) {
                answer++;
            }
            return;
        }

        for (int p = 0; p < 8; p++) {
            if (used[p]) {
                continue;
            }
            used[p] = true;
            pos[p] = depth;
            dfs(depth + 1);
            used[p] = false;
        }
    }

    static boolean checkAll() {
        for (String c : cond) {
            int a = idx.get(c.charAt(0));
            int b = idx.get(c.charAt(2));
            char op = c.charAt(3);
            int k = c.charAt(4) - '0';

            int gap = Math.abs(pos[a] - pos[b]) - 1;

            if (op == '=') {
                if (gap != k) {
                    return false;
                }
            } else if (op == '<') {
                if (gap >= k) {
                    return false;
                }
            } else {
                if (gap <= k) {
                    return false;
                }
            }
        }
        
        return true;
    }
}