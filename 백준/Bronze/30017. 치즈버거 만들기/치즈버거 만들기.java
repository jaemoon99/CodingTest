import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        while (true) {
            if (A > B) {
                break;
            }
            B--;
        }
        System.out.println((2 * B + 1));

        scanner.close();
    }
}