class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String[] bin = binomial.split(" ");
        
        if (bin[1].equals("+")) {
            answer = Integer.parseInt(bin[0]) + Integer.parseInt(bin[2]);
        } else if (bin[1].equals("-")) {
            answer = Integer.parseInt(bin[0]) - Integer.parseInt(bin[2]);
        } else if (bin[1].equals("*")) {
            answer = Integer.parseInt(bin[0]) * Integer.parseInt(bin[2]);
        }
        
        return answer;
    }
}