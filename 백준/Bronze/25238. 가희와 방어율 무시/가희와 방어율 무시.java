import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        double result = a - (double) (a * b) / 100;
        if (result >= 100) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        scanner.close();
    }
}