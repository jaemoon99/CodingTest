import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = scanner.nextInt();
        int[] nums = {
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt()
        };

        int count = 0;
        for (int num : nums) {
            if (num == day) {
                count++;
            }
        }
        System.out.println(count);
        
        scanner.close();
    }
}