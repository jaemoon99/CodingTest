import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int b = Integer.parseInt(str.split(" ")[1]);

        StringBuilder result = new StringBuilder();
        while (n > 0) {
            if (n % b < 10) {
                result.append((char) (n % b + '0'));
            } else {
                result.append((char) (n % b - 10 + 'A'));
            }
            n /= b;
        }

        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
    }
}