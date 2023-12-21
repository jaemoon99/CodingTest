import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int result = 0;
        int count = 0;

        while (l > result){
            result += 5;
            count++;
        }

        System.out.println(count);
    }
}