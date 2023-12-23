import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();

            if (str.equals("#")) {
                break;
            }

            int count = 0;
            for (String s : str.split("")) {
                if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u")) {
                    count++;
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}