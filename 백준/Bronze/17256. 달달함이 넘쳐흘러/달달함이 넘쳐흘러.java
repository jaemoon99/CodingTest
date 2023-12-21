import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        int[] c = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};

        int temp = a[2];
        a[2] = a[0];
        a[0] = temp;

        for (int i = 0; i < a.length; i++){
            if (i == 1){
                a[i] = c[i] / a[i];
            } else {
                a[i] = c[i] - a[i];
            }
        }

        for (int i : a) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
