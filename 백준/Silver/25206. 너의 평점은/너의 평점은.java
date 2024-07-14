import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        double totalScore = 0;
        double totalCredit = 0;
        for (int i = 0; i < 20; i++) {
            String[] info = sc.nextLine().split(" ");
            int credit = Integer.parseInt(info[1].split("\\.")[0]);
            switch (info[2]) {
                case "A+": totalScore += credit * 4.5; totalCredit += credit; break;
                case "A0": totalScore += credit * 4.0; totalCredit += credit; break;
                case "B+": totalScore += credit * 3.5; totalCredit += credit; break;
                case "B0": totalScore += credit * 3.0; totalCredit += credit; break;
                case "C+": totalScore += credit * 2.5; totalCredit += credit; break;
                case "C0": totalScore += credit * 2.0; totalCredit += credit; break;
                case "D+": totalScore += credit * 1.5; totalCredit += credit; break;
                case "D0": totalScore += credit * 1.0; totalCredit += credit; break;
                case "F": totalScore += credit * 0.0; totalCredit += credit; break;
            }
        }

        System.out.println(totalScore / totalCredit);
    }
}