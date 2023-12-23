import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextLong();
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            
            x -= a * b;
        }

        if (x == 0) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");

        scanner.close();
    }
}