import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long total = 0;

        while (true) {
            long quantity = scanner.nextLong();

            if (quantity == -1) {
                System.out.println(total);
                break;
            }

            total += quantity;

        }

        scanner.close();
    }
}