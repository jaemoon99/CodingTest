import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String nums = scanner.nextLine();

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums.charAt(i) - '0';
        }
        System.out.println(total);

        scanner.close();
    }
}