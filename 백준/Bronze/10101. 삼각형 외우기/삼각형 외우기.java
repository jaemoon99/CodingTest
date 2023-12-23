import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int angle1 = scanner.nextInt();
        int angle2 = scanner.nextInt();
        int angle3 = scanner.nextInt();

        List<Integer> nums = Arrays.asList(angle1, angle2, angle3);
        SortedSet<Integer> numsSet = new TreeSet<>(nums);

        if (angle1 + angle2 + angle3 != 180){
            System.out.println("Error");
        } else {
            if (numsSet.size() == 1) {
                System.out.println("Equilateral");
            } else if (numsSet.size() == 2) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }

        scanner.close();
    }
}