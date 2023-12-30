import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = 0;

        result += b;
        n -= b;
        result += Math.min(n, a / 2);

        System.out.println(result);

        scanner.close();
    }
}