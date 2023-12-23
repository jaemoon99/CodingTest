import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = scanner.nextInt();
        int day = scanner.nextInt();

        if (month > 2) {
            System.out.println("After");
        } else if (month == 2) {
            if (day > 18) {
                System.out.println("After");
            } else if (day == 18) {
                System.out.println("Special");
            } else {
                System.out.println("Before");
            }
        } else {
            System.out.println("Before");
        }

        scanner.close();
    }
}