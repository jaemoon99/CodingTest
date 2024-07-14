import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String s : strArr) {
            for (int i = 0; i < str.length() - s.length() + 1; i++) {
                String subStr = str.substring(i, i + s.length());
                if (s.equals(subStr)) {
                    str = str.replace(s, "1");
                    break;
                }
            }
        }
        System.out.println(str.length());
    }
}