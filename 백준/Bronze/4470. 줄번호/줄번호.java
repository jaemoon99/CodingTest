import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            String str = scanner.nextLine();
            System.out.println(i + ". " + str);
        }

        scanner.close();
    }
}