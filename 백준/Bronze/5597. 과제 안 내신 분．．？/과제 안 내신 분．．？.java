import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] students = new int[30];

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            students[num - 1] = num;
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                System.out.println(i + 1);
            }
        }

        scanner.close();
    }
}