import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String aaah = scanner.nextLine();
        String aah = scanner.nextLine();

        if (aaah.length() >= aah.length()) {
            System.out.println("go");
            return;
        }
        System.out.println("no");
        scanner.close();
    }
}
