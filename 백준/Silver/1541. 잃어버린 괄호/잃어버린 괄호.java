import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        
        br.close();

        String[] minusParts = expr.split("-");

        int answer = sumPlus(minusParts[0]);
        for (int i = 1; i < minusParts.length; i++) {
            answer -= sumPlus(minusParts[i]);
        }

        System.out.println(answer);
    }

    private static int sumPlus(String part) {
        String[] nums = part.split("\\+");
        
        int sum = 0;
        for (String n : nums) {
            sum += Integer.parseInt(n);
        }
        
        return sum;
    }
}