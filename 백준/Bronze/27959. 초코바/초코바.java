import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if (n * 100 >= m) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
        
        scanner.close();
    }
}