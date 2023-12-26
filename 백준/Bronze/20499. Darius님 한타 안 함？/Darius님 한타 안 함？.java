import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] kda = str.split("/");

        int k = Integer.parseInt(kda[0]);
        int d = Integer.parseInt(kda[1]);
        int a = Integer.parseInt(kda[2]);

        if (k + a < d || d == 0) {
            System.out.println("hasu");
            return;
        }
        System.out.println("gosu");

        scanner.close();
    }
}