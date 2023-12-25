import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int k = scanner.nextInt();
        int h = scanner.nextInt();

        int[] scores = {s, k, h};

        if (Arrays.stream(scores).sum() >= 100) {
            System.out.println("OK");
        } else {
            if (Arrays.stream(scores).min().getAsInt() == s) {
                System.out.println("Soongsil");
            } else if (Arrays.stream(scores).min().getAsInt() == k) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
        scanner.close();
    }
}