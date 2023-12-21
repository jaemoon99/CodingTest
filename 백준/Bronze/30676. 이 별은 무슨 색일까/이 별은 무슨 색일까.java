import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nm = scanner.nextInt();
        
        if (780 >= nm && nm >= 620) {
            System.out.println("Red");
        } else if (620 > nm && nm >= 590) {
            System.out.println("Orange");
        } else if (590 > nm && nm >= 570) {
            System.out.println("Yellow");
        } else if (570 > nm && nm >= 495) {
            System.out.println("Green");
        } else if (495 > nm && nm >= 450) {
            System.out.println("Blue");
        } else if (450 > nm && nm >= 425) {
            System.out.println("Indigo");
        } else if (425 > nm && nm >=380) {
            System.out.println("Violet");
        }

        scanner.close();
    }
}