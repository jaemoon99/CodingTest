import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int K = scanner.nextInt();
        int X = scanner.nextInt();

        int result = 0;
        for (int i = A; i <= B; i++) {
            if (K + X >= i && i >= K - X) {
                result++;
            }
        }

        if (result == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(result);

        scanner.close();
    }
}