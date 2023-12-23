import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int price = scanner.nextInt();
        int quantity = scanner.nextInt();
        int ownMoney = scanner.nextInt();

        if (price * quantity > ownMoney) {
            System.out.println(price * quantity - ownMoney);
            return;
        }
        System.out.println(0);

        scanner.close();
    }
}