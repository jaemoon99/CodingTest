import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String n = str.split(" ")[0];
        int b = Integer.parseInt(str.split(" ")[1]);

        StringBuilder newN = new StringBuilder();
        for (int i = n.length() - 1; i >= 0 ; i--) {
            newN.append(n.charAt(i));
        }

        int temp = 1;
        int result = 0;
        for (int i = 0; i < newN.length(); i++) {
            if (newN.charAt(i) >= 'A' && newN.charAt(i) <= 'Z') {
                result += (newN.charAt(i) - 55) * temp;
            } else {
                result += (newN.charAt(i) - 48) * temp;
            }
            temp *= b;
        }

        System.out.println(result);
    }
}