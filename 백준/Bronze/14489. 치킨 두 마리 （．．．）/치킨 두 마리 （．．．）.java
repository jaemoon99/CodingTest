import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int accountA = scanner.nextInt();
        int accountB = scanner.nextInt();
        int price = scanner.nextInt();

        if (accountA + accountB >= price * 2) {
            System.out.println(accountA + accountB - (price * 2));
            return;
        }
        System.out.println(accountA + accountB);

        scanner.close();
    }
}