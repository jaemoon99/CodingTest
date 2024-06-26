class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        if (arr1.length > arr2.length) {
            answer = 1;
        } else if (arr1.length < arr2.length) {
            answer = -1;
        } else {
            int arr1Result = 0, arr2Result = 0;
            
            for (int i = 0; i < arr1.length; i++) {
                arr1Result += arr1[i];
                arr2Result += arr2[i];
            }

            if (arr1Result > arr2Result) {
                answer = 1;
            } else if (arr1Result < arr2Result) {
                answer = -1;
            }
        }
        
        return answer;
    }
}