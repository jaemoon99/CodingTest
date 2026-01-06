class Solution {
    public int solution(int[] a) {
        if (a.length == 1) {
            return 1;
        }

        int answer = 2;

        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        int lMin = a[0];
        int rMin = a[a.length - 1];

        for (int i = 1; i < a.length; i++) {
            lMin = Math.min(lMin, a[i]);
            leftMin[i] = lMin;
        }

        for (int i = a.length - 2; i > 0; i--) {
            rMin = Math.min(rMin, a[i]);
            rightMin[i] = rMin;
        }

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}