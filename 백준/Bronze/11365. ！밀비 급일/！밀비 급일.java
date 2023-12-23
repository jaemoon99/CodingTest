import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();

            if (str.equals("END")) {
                break;
            }

            StringBuffer bufferStr = new StringBuffer(str);
            String reverse = bufferStr.reverse().toString();

            System.out.println(reverse);
        }
        
        scanner.close();
    }
}