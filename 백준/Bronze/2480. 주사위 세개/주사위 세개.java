import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fir = sc.nextInt();
        int sec = sc.nextInt();
        int thr = sc.nextInt();

        if (fir == sec && sec == thr) {
            int result = 10000 + fir * 1000;
            System.out.println(result);
            return;
        }

        if (fir == sec || sec == thr) {
            int result = 1000  + sec * 100;
            System.out.println(result);
            return;
        }

        if (fir == thr) {
            int result = 1000 + fir * 100;
            System.out.println(result);
            return;
        }
        int max = Math.max(fir, sec);
        int result = Math.max(max, thr) * 100;
        System.out.println(result);
    }
}