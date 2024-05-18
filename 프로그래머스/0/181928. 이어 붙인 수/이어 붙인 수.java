class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        
        int oddMag = 1;
        int evenMag = 1;
        
        for (int i = num_list.length - 1; i >= 0; i--) {
            
            if (num_list[i] % 2 == 0) {
                even += num_list[i] * evenMag;
                evenMag *= 10;
            } else {
                odd += num_list[i] * oddMag;
                oddMag *= 10; 
            }
        }
        
        return odd + even;
    }
}