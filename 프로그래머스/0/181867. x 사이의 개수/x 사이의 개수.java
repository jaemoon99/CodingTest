class Solution {
    public int[] solution(String myString) {
        String[] splitArray = myString.split("x");
        int[] answer = new int[(myString.charAt(myString.length() - 1) == 'x' ? splitArray.length + 1 : splitArray.length)];
        
        for (int i = 0; i < splitArray.length; i++) {
            answer[i] = splitArray[i].length();
        }
        
        return answer;
    }
}