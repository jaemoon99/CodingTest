import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        b += d / 60;
        c += d % 60;

        while (60 <= c) {
            b++;
            c -= 60;
        }

        while (60 <= b) {
            a++;
            b -= 60;
        }

        while (24 <= a) {
            a -= 24;
        }

        System.out.println(a + " " + b + " " + c);

        scanner.close();
    }
}