import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int totalTime = 0;
        for (int i = 0; i < N; i++) {
            totalTime += scanner.nextInt();

            if (i != N - 1) {
                totalTime += 8;
            }
        }

        System.out.println(totalTime / 24 + " " + totalTime % 24);

        scanner.close();
    }
}