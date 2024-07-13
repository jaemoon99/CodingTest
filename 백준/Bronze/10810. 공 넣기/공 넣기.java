import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < m; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();

            for (int o = j - 1; o < k; o++) {
                arr[o] = l;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}