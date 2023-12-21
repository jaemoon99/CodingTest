import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] nums = new int[scanner.nextInt()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int v = scanner.nextInt();
        int count = 0;
        
        for (int num : nums) {
            if (num == v) {
                count++;
            }
        }

        System.out.println(count);

        scanner.close();
    }
}