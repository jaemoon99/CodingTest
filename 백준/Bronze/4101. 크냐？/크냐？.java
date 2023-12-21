import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            
            if (n == 0 && m == 0) {
                break;
            }
            if (n > m) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
