import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long l = scanner.nextLong();
        long p = scanner.nextLong();
        long[] peoples = {
                scanner.nextLong(),
                scanner.nextLong(),
                scanner.nextLong(),
                scanner.nextLong(),
                scanner.nextLong()
        };

        for (long people : peoples) {
            System.out.print(people - l * p + " ");
        }

        scanner.close();
    }
}