import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        int scoreD = 0;
        int scoreP = 0;

        for (int i = 0; i < N; i++) {
            if (Math.abs(scoreD - scoreP) >= 2) {
                break;
            }
            
            String win = scanner.nextLine();
            if (win.equals("D")) {
                scoreD++;
            } else if (win.equals("P")) {
                scoreP++;
            }
        }

        System.out.println(scoreD + ":" + scoreP);

        scanner.close();
    }
}