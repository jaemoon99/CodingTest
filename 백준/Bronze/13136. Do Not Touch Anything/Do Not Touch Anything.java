import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long R = scanner.nextLong();
        long C = scanner.nextLong();
        long N = scanner.nextLong();

        R = (R % N == 0) ? R / N : R / N + 1;
        C = (C % N == 0) ? C / N : C / N + 1;

        System.out.println(R * C);

        scanner.close();
    }
}
