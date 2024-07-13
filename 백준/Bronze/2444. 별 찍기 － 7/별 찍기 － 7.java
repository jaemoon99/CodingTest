import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int starCount = n - (n - 1);
        int blankCount = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < blankCount; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < starCount; k++) {
                System.out.print("*");
            }

            starCount+=2;
            blankCount--;
            System.out.println();
        }

        int subStarCount = starCount - 4;
        int subBlankCount = blankCount + 2;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < subBlankCount; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < subStarCount; k++) {
                System.out.print("*");
            }
            
            subStarCount-=2;
            subBlankCount++;
            System.out.println();
        }

    }
}