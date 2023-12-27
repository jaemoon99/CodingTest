import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        int E = scanner.nextInt();

        int time = E;

        if (A >= 0) {
            time = 0;
        }

        while (A != B) {
            if (0 > A) {
                time += C;
            } else if (A == 0) {
                time += D;
            } else {
                time += E;
            }
            A += 1;
        }
        System.out.println(time);

        scanner.close();
    }
}