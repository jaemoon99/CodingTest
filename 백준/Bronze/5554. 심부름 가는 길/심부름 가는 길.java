import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalTime = scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt();

        int minute = 0;
        while (totalTime >= 60) {
            minute++;
            totalTime -= 60;
        }
        System.out.println(minute);
        System.out.println(totalTime);

        scanner.close();
    }
}