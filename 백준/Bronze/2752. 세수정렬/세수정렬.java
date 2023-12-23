import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.asList(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        SortedSet<Integer> numsSort = new TreeSet<>(nums);

        for (Integer num : numsSort) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}