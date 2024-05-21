class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;

        if (myString.replace("A", "C").replace("B", "A").replace("C", "B").contains(pat)) {
            answer = 1;
        }
        
        return answer;
    }
}