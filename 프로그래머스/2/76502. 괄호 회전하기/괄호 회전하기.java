import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 != 0) {
            return 0;
        }
        
        int answer = 0;
        
        String[] c = s.split("");
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            dq.add(c[i]);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (check(dq)){
                answer++;
            }
            
            dq.addLast(dq.pollFirst());
        }
        
        return answer;
    }
    
    public boolean check(Deque<String> dq) {
        Deque<Character> st = new ArrayDeque<>();

        for (String token : dq) {
            char ch = token.charAt(0);
            switch (ch) {
                case '(': case '[': case '{':
                    st.push(ch);
                    break;
                case ')':
                    if (st.isEmpty() || st.pop() != '(') return false;
                    break;
                case ']':
                    if (st.isEmpty() || st.pop() != '[') return false;
                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{') return false;
                    break;
                default:
                    return false;
            }
        }
        return st.isEmpty();
    }
}