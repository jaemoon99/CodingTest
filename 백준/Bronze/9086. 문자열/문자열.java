import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            String str = scanner.nextLine();
            System.out.println(str.charAt(0) + "" + str.charAt(str.length() - 1));
        }

        scanner.close();
    }
}
