import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int r = sc.nextInt();
            String s = sc.nextLine().replace(" ", "");

            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < r; k++) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}