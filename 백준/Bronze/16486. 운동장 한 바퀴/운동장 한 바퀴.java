import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double d1 = scanner.nextInt();
        double d2 = scanner.nextInt();
        double pi = 3.141592;

        System.out.println(((d1 * 2.0) + (d2 * 2.0 * pi)));

        scanner.close();
    }
}