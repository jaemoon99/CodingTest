import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                System.out.print("=");
            }
            System.out.println();
        }

        scanner.close();
    }
}