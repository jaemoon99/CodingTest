import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        br.close();

        final long MOD = 1234567891L;

        long result = 0;
        long pow = 1;

        for (int i = 0; i < l; i++) {
            long val = (str.charAt(i) - 'a' + 1);
            result = (result + val * pow) % MOD;
            pow = (pow * 31) % MOD;
        }

        System.out.println(result);
    }
}