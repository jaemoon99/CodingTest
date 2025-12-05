import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        char[] arr = s.toCharArray();

        int starIdx = -1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*') {
                starIdx = i;
                continue;
            }
            int digit = arr[i] - '0';
            int weight = (i % 2 == 0) ? 1 : 3;
            sum += digit * weight;
        }

        int need = (10 - (sum % 10)) % 10;
        int starWeight = (starIdx % 2 == 0) ? 1 : 3;
        int x;

        if (starWeight == 1) {
            x = need;
        } else {
            x = (7 * need) % 10;
        }

        System.out.println(x);
    }
}