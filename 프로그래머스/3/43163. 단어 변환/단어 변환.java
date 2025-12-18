import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 999_999_999;

        boolean flag = false;
        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
            }
        }

        if (!flag) {
            return 0;
        }

        for (int i = 0; i < words.length; i++) {
            if (isEquals(begin, words[i])) {
                int result = bfs(i, words, target);
                if (result != -1) {
                    answer = Math.min(answer, result);
                }
            }
        }

        return answer;
    }

    public int bfs (int start, String[] words, String target) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] v =  new boolean[words.length];

        dq.offer(start);

        int cnt = 0;
        while (!dq.isEmpty()) {
            int poll = dq.poll();
            cnt++;

            v[poll] = true;

            if (words[poll].equals(target)) {
                return cnt;
            }

            for (int i = 0; i < words.length; i++) {
                if (!v[i] && isEquals(words[i], words[poll])) {
                    dq.add(i);
                }
            }
        }

        return -1;
    }

    public boolean isEquals(String s1, String s2) {
        int cnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                cnt++;
            }
        }

        return cnt == s1.length() - 1;
    }
}