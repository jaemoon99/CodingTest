import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
                
        List<Integer> lst = new ArrayList<>();
        for (String operation : operations) {
            String[] splits = operation.split(" ");
            
            if (splits[0].equals("I")) {
                int value = Integer.parseInt(splits[1]);
                lst.add(value);
            }
            
            if (operation.equals("D -1") && !lst.isEmpty()) {
                Collections.sort(lst);
                lst.remove(0);
            }
            
            if (operation.equals("D 1") && !lst.isEmpty()) {
                Collections.sort(lst);
                lst.remove(lst.size() - 1);
            }
        }
        
        if (lst.isEmpty()) {
            return new int[] {0, 0};
        }
        
        Collections.sort(lst);
        
        return new int[] {lst.get(lst.size() - 1), lst.get(0)};
    }
}