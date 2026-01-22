import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        List<String> du = new ArrayList<>();

        du.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!check(words[i - 1], words[i]) || du.contains(words[i])) {
                return new int[] {i % n + 1, i / n + 1};
            }

            du.add(words[i]);
        }

        return new int[] {0, 0};
    }

    public boolean check(String str1, String str2) {
		return str1.charAt(str1.length() - 1) == str2.charAt(0);
	}
}