import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();
        
        int power = 1;
        while (power * 2 <= n) {
            power *= 2;
        }

        if (n == power) {
            System.out.println(n);
        } else {
            System.out.println(2 * (n - power));
        }
    }
}