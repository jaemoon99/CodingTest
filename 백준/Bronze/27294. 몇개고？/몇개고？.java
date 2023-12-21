import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int s = scanner.nextInt();

        if ((16 >= t && t >= 12) && s == 0) {
            System.out.println(320);
            return;
        }
        System.out.println(280);
    }
}
