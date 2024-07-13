import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int time = sc.nextInt();

        min += time;

        while (min > 59) {
            hour++;
            min -= 60;
        }

        while (hour > 23) {
            hour -= 24;
        }

        System.out.println(hour + " " + min);
    }
}