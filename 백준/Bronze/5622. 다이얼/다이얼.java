import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        int total = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) >= 'A' && name.charAt(i) <= 'C') {
                total += 3;
            }

            if (name.charAt(i) >= 'D' && name.charAt(i) <= 'F') {
                total += 4;
            }

            if (name.charAt(i) >= 'G' && name.charAt(i) <= 'I') {
                total += 5;
            }

            if (name.charAt(i) >= 'J' && name.charAt(i) <= 'L') {
                total += 6;
            }

            if (name.charAt(i) >= 'M' && name.charAt(i) <= 'O') {
                total += 7;
            }

            if (name.charAt(i) >= 'P' && name.charAt(i) <= 'S') {
                total += 8;
            }

            if (name.charAt(i) >= 'T' && name.charAt(i) <= 'V') {
                total += 9;
            }

            if (name.charAt(i) >= 'W' && name.charAt(i) <= 'Z') {
                total += 10;
            }
        }
        System.out.println(total);
    }
}