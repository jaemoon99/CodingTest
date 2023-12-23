import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int y = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println((m + m - y));

        scanner.close();
    }
}