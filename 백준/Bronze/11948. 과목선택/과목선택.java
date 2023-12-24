import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] scienceScores = {
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
        };

        int[] socialScores = {
                scanner.nextInt(),
                scanner.nextInt(),
        };

        Arrays.sort(scienceScores);
        Arrays.sort(socialScores);

        int totalScore = 0;
        for (int scienceScore : scienceScores) {
            totalScore += scienceScore;

        }

        for (int socialScore : socialScores) {
            totalScore += socialScore;
        }

        System.out.println(totalScore - scienceScores[0] - socialScores[0]);

        scanner.close();
    }
}