import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[100][100];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int x = Integer.parseInt(str.split(" ")[0]);
            int y = Integer.parseInt(str.split(" ")[1]);
            
            for (int j = y; j < y + 10; j++){
                for (int k = x; k < x + 10; k++){
                    if (arr[j][k] == 0){
                        arr[j][k] = 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}