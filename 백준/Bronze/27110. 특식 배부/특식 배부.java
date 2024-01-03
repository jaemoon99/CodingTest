import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int result = 0;
        for (int i = 0; i < 3; i++) {
            int soldier = scanner.nextInt();

            result += Math.min(N, soldier);
        }
        System.out.println(result);

        scanner.close();
    }
}