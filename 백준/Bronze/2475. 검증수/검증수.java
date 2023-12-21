import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fir = scanner.nextInt();
        int sec = scanner.nextInt();
        int thi = scanner.nextInt();
        int fou = scanner.nextInt();
        int fif = scanner.nextInt();

        System.out.println((int) (Math.pow(fir, 2) + Math.pow(sec, 2) + Math.pow(thi, 2) + Math.pow(fou, 2) + Math.pow(fif, 2)) % 10);

        scanner.close();
    }
}