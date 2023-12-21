import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String result = "";

        for (char ch : str.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result += Character.toUpperCase(ch);
                continue;
            }
            result += Character.toLowerCase(ch);
        }

        System.out.println(result);
    }
}
