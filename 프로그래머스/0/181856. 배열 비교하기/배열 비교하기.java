class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        if (arr1.length > arr2.length) {
            answer = 1;
        } else if (arr1.length < arr2.length) {
            answer = -1;
        } else {
            int arr1Result = 0;
            int arr2Result = 0;
            
            for (int num : arr1) {
                arr1Result += num;
            }
            
            for (int num : arr2) {
                arr2Result += num;
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