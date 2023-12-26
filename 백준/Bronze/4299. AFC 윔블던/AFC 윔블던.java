import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = scanner.nextInt();
        int sub = scanner.nextInt();

        int avg = (sum - sub) / 2;

        if ((sum + sub) % 2 != 0 || sum < sub ) {
            System.out.println(-1);
            return;
        }
        System.out.println((avg + sub) + " " + avg);

        scanner.close();
    }
}
