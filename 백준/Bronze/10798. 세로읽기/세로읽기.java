import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String[] str = sc.nextLine().split("");
            for (int j = 0; j < 15; j++) {
                if (j > str.length - 1) {
                    arr[i][j] = "";
                } else {
                    arr[i][j] = str[j];
                }

            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[j][i]);
            }
        }
        System.out.println();
    }
}