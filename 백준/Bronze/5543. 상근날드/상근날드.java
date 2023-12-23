import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> buger = new ArrayList<>(Arrays.asList(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        ArrayList<Integer> juice = new ArrayList<>(Arrays.asList(scanner.nextInt(), scanner.nextInt()));
        
        System.out.println(Collections.min(buger) + Collections.min(juice) - 50);

        scanner.close();
    }
}