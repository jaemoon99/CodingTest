import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.nextLine();

        if (n.equals("N") || n.equals("n")) {
            System.out.println("Naver D2");
            return;
        }
        System.out.println("Naver Whale");

        scanner.close();
    }
}