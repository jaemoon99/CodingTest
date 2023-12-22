import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int sum = 0;
        int totalSquare = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            totalSquare += (int) Math.pow(i, 3);
        }
        int sumSquare = (int) Math.pow(sum, 2);

        System.out.println(sum);
        System.out.println(sumSquare);
        System.out.println(totalSquare);

        scanner.close();
    }
}