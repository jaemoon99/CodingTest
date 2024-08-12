import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * 2 ~ 7 = 1
         * 8 ~ 19 = 2
         * 20 ~ 37 = 3
         * ...
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int num = 1;
        int count = 1;
        while (num < n) {
            num += 6 * count;
            count++;
        }
        System.out.println(count);
    }
}
