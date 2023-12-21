import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        double fir = n * 0.78;
        double sec = n * 0.8 + n * 0.2 * 0.78;
        System.out.println((int) fir + " " + (int) sec);
    }
}
