import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int m = scanner.nextInt();
            int f = scanner.nextInt();

            if (m == 0 && f == 0) {
                break;
            }

            System.out.println(m + f);
        }

        scanner.close();
    }
}