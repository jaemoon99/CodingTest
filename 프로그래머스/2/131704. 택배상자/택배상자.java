import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int orderIdx = 0;
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        while (orderIdx < order.length) {
            
            if (num <= order.length && num == order[orderIdx]) {
                answer++;
                num++;
                orderIdx++;
                continue;
            } 
            if (!stack.isEmpty() && stack.peek() == order[orderIdx]) {
                stack.pop();
                answer++;
                orderIdx++;
            } else {
                
                if (num > order.length) {
                    break;
                }
                
                stack.push(num);
                num++;
            }
        }

        return answer;
    }
}