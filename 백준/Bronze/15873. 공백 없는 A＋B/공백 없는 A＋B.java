import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int AB = scanner.nextInt();

        if (AB == 1010) {
            System.out.println(20);
        } else if (AB >= 110) {
            System.out.println((AB / 100) + (AB % 100));
        } else {
            System.out.println((AB / 10) + (AB % 10));
        }

        scanner.close();
    }
}