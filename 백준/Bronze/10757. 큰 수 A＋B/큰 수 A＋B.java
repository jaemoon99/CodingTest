import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = scanner.nextBigInteger();
        String b = scanner.nextLine().trim();

        BigInteger result = a.add(new BigInteger(b));

        System.out.println(result);

        scanner.close();
    }
}