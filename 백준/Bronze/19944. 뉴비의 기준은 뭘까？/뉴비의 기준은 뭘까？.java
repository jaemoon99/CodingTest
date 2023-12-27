import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        if (M == 1 || M == 2) {
            System.out.println("NEWBIE!");
        } else if (N >= M) {
            System.out.println("OLDBIE!");
        } else {
            System.out.println("TLE!");
        }

        scanner.close();
    }
}