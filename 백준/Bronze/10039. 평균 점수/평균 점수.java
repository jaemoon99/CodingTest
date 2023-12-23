import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalScore = 0;
        for (int i = 0; i < 5; i++) {
            int score = scanner.nextInt();
            
            if (score >= 40) {
                totalScore += score;
            } else {
                totalScore += 40;
            }
        }
        System.out.println(totalScore / 5);

        scanner.close();
    }
}