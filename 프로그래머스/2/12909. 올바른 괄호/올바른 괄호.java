import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && s.charAt(i) == ')') {
                answer = false;
                break;
            }

            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }

            if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
            }

        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}