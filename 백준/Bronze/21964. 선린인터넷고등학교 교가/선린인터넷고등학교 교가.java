import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        char[] arrays = scanner.nextLine().toCharArray();

        for (int i = N - 5; i < N; i++) {
            System.out.print(arrays[i]);
        }
        System.out.println();

        scanner.close();
    }
}