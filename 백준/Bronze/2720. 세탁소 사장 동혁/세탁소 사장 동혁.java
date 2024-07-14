import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coin = {25, 10, 5, 1};

        for (int i = 0; i < n; i++) {
            int change = sc.nextInt();

            for (int j = 0; j < 4; j++) {
                System.out.print(change / coin[j] + " ");
                change %= coin[j];
            }
            System.out.println();
        }
    }
}