import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int b = scanner.nextInt();

        System.out.println(b / 11 * 10);
        
        scanner.close();
    }
}