import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        String c = "" + b;

        for (int i = c.length() - 1; i >= 0; i--) {
            System.out.println(Integer.parseInt("" + c.charAt(i)) * a);
        }

        System.out.println(a * b);
    }
}