import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();

        if (((A * B) / C) >= ((A / B) * C)) {
            System.out.println((int) ((A * B) / C));
            return;
        }
        System.out.println((int) ((A / B) * C));

        scanner.close();
    }
}