import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();

        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!check(words[i - 1], words[i]) || set.contains(words[i])) {
                return new int[] {i % n + 1, i / n + 1};
            }

            set.add(words[i]);
        }

        return new int[] {0, 0};
    }

    public boolean check(String str1, String str2) {
		return str1.charAt(str1.length() - 1) == str2.charAt(0);
	}
}