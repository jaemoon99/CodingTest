import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] coins =  new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coins[i] > k) {
                continue;
            }

            answer += k / coins[i];
            k %= coins[i];
        }

        System.out.println(answer);
    }
}