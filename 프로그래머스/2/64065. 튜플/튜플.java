import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        String[] splits = s.split("},\\{");

        splits[0] = splits[0].replace("{", "");
        splits[splits.length - 1] = splits[splits.length - 1].replace("}", "");

        Arrays.sort(splits, (a, b) -> a.length() - b.length());

        int[] answer = new int[splits.length];
        Set<Integer> set = new HashSet<>();
        int idx = 0;

        for (String split : splits) {
            String[] nums = split.split(",");
            for (String num : nums) {
                int value = Integer.parseInt(num);
                if (!set.contains(value)) {
                    set.add(value);
                    answer[idx++] = value;
                }
            }
        }

        return answer;
    }
}