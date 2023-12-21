import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a > b) {
            System.out.println("Subway");
        } else if (b > a) {
            System.out.println("Bus");
        } else {
            System.out.println("Anything");
        }

        scanner.close();
    }
}