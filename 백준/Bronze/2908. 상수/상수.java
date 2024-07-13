import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "" + sc.nextInt();
        String b = "" + sc.nextInt();

        StringBuilder tempA = new StringBuilder();
        StringBuilder tempB = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            tempA.append(a.charAt(i));
        }

        for (int i = b.length() - 1; i >= 0; i--) {
            tempB.append(b.charAt(i));
        }
        System.out.println(Math.max(Integer.parseInt(tempA.toString()), Integer.parseInt(tempB.toString())) );
    }
}