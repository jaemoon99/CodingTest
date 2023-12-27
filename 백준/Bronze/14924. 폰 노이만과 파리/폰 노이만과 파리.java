import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int S = scanner.nextInt();
        int T = scanner.nextInt();
        int D = scanner.nextInt();

        System.out.println((T * (D / (S * 2))));

        scanner.close();
    }
}