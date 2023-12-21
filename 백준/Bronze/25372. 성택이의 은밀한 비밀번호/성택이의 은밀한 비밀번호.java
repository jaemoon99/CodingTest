import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();
            if (9 >= password.length() && password.length() >= 6) {
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
    }
}
