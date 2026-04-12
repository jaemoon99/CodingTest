import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long[] count = new long[10];

    static void calc(long x, long digit) {
        while (x > 0) {
            count[(int)(x % 10)] += digit;
            x /= 10;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long start = 1;
        long end = n;
        long digit = 1;

        while (start <= end) {
            while (end % 10 != 9 && start <= end) {
                calc(end, digit);
                end--;
            }

            if (start > end) break;

            while (start % 10 != 0 && start <= end) {
                calc(start, digit);
                start++;
            }

            start /= 10;
            end /= 10;

            for (int i = 0; i < 10; i++) {
                count[i] += (end - start + 1) * digit;
            }

            digit *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append(' ');
        }
        System.out.println(sb);
    }
}