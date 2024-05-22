class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int size = 0;
        for (boolean work : finished) {
            if (!work) {
                size++;
            }
        }
        
        String[] answer = new String[size];
        
        int idx = 0;
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) {
                answer[idx++] = todo_list[i];
            }
        }
        
        return answer;
    }
}