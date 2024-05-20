import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        List<String> middleArray = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")) {
                middleArray.add(str);
            }
        }
        return middleArray.toArray(answer);
    }
}