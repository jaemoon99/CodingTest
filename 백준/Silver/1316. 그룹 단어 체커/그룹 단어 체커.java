import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int n = sc.nextInt();
        int count = 0;
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check() {
        boolean[] check = new boolean[26];
        int prev = 0;

        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (!check[now - 'a']) {
                    check[now - 'a'] = true;
                } else {
                    return false;
                }
            }
            prev = now;
        }
        return true;
    }
}