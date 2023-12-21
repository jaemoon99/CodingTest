import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        BigInteger total = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            total = total.multiply(BigInteger.valueOf(i));
        }

        System.out.println(total);
    }
}
