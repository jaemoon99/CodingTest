import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder res = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }

        if (str.equals("" + res)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}