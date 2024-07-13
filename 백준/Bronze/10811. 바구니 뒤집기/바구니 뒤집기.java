import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();

            int[] temp = new int[k - j + 1];
            int tempIndex = 0;
            for (int l = j - 1; l < k; l++) {
                temp[tempIndex++] = arr[l];
            }

            tempIndex--;
            for (int l = j - 1; l < k; l++) {
                arr[l] = temp[tempIndex--];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}