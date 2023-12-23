import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        double koreanDay = (double) a / c;
        double mathDay = (double) b / d;

        if (koreanDay >= mathDay) {
            System.out.println( l - (int) Math.ceil(koreanDay));
            return;
        }
        System.out.println(l - (int) Math.ceil(mathDay));

        scanner.close();
    }
}