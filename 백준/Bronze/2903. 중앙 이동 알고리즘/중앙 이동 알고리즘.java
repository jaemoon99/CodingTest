import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index = 0;
        int start = 2;

        while (true) {
            if (index == n) {
                System.out.println(start * start);
                break;
            }

            index++;
            start += start - 1;
        }
    }
}