import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int result = 0;
        for (int i = 0; i < N; i++) {
            String dDay = scanner.nextLine();

            String[] dDayList = dDay.split("-");

            if (90 >= Integer.parseInt(dDayList[1])) {
                result++;
            }
        }
        System.out.println(result);

        scanner.close();
    }
}