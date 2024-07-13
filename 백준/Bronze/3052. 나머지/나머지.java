import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int[] checkArr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            checkArr[i] = -1;
        }

        int[] temp = new int[10];
        for (int i = 0; i < 10; i++) {
            temp[i] = arr[i] % 42;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    checkArr[j] = temp[j];
                    break;
                } else {
                    if (temp[i] == checkArr[j]) {
                        break;
                    }
                    if (checkArr[j] == -1) {
                        checkArr[j] = temp[i];
                        break;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (checkArr[i] != -1) {
                count++;
            }
        }
        System.out.println(count);
    }
}