import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            System.out.println(name.toLowerCase());
        }

        scanner.close();
    }
}