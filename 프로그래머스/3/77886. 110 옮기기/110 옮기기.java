import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] ans = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            ans[i] = transform(s[i]);
        }
        return ans;
    }

    private String transform(String str) {
        
        char[] stack = new char[str.length()];
        int top = 0;
        int cnt110 = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack[top++] = c;

            if (top >= 3 && stack[top - 3] == '1' && stack[top - 2] == '1' && stack[top - 1] == '0') {
                top -= 3;
                cnt110++;
            }
        }

        String rem = new String(stack, 0, top);

        int pos = rem.length();
        while (pos > 0 && rem.charAt(pos - 1) == '1') {
            pos--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rem, 0, pos);
		sb.append("110".repeat(Math.max(0, cnt110)));
        sb.append(rem.substring(pos));

        return sb.toString();
    }
}