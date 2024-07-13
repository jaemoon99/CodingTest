import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            max = Math.max(max, scores[i]);
        }

        double totalScore = 0;
        for (int i = 0; i < n; i++) {
            totalScore += (double) scores[i] / max * 100;
        }

        System.out.println(totalScore / n);
    }
}