import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger n = scanner.nextBigInteger();

        System.out.println(n.multiply(n.subtract(BigInteger.valueOf(1))));

        scanner.close();
    }
}