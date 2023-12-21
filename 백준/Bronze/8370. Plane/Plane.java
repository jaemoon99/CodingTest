import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n1 = scanner.nextLong();
        long k1 = scanner.nextLong();
        long n2 = scanner.nextLong();
        long k2 = scanner.nextLong();

        System.out.println((n1 * k1) + (n2 * k2));
    }
}
