import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] lecture = new int[n];
        int maxLen = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            lecture[i] = sc.nextInt();
            maxLen = Math.max(maxLen, lecture[i]);
            total += lecture[i];
        }
        
        sc.close();

        int s = maxLen;
        int e = total;
        int result = total;

        while (s <= e) {
            int mid = (s + e) / 2;

            int cnt = 1;
            int sum = 0;
            for (int len : lecture) {
                if (sum + len > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += len;
            }

            if (cnt <= m) {
                result = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(result);
    }
}