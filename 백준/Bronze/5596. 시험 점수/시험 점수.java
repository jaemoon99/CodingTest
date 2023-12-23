import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mg = scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int ms = scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt();

        if (mg >= ms) {
            System.out.println(mg);
            return;
        }
        System.out.println(ms);

        scanner.close();
    }
}