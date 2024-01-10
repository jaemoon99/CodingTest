import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int U = scanner.nextInt();
        int L = scanner.nextInt();

        if (N >= 1000 && (U >= 8000 || L >= 260)) {
            System.out.println("Very Good");
        } else if (N >= 1000) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        } 

        scanner.close();
    }
}