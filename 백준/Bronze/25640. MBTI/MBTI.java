import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String MBTI = scanner.nextLine();
        int N = scanner.nextInt();
        scanner.nextLine();

        int result = 0;
        for (int i = 0; i < N; i++) {
            String MBTI2 = scanner.nextLine();

            if (MBTI.equals(MBTI2)) {
                result++;
            }
        }
        System.out.println(result);

        scanner.close();
    }
}