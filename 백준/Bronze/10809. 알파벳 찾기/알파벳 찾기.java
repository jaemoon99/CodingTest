import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for (int i = 97; i <= 122; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if ((int) str.charAt(j) == i) {
                    System.out.print(j + " ");
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.print(-1 + " ");
            }
        }
    }
}