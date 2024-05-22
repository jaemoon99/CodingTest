import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> numList = new ArrayList<>();
        
        for (int num : arr) {
            int count = 0;
            for (int delete : delete_list) {
                if (num == delete) {
                    count++;
                }
            }
            if (count == 0) {
                numList.add(num);
            }
        }
        
        int[] answer = new int[numList.size()];
        
        for (int i = 0; i < numList.size(); i++) {
            answer[i] = numList.get(i);
        }
        
        return answer;
    }
}