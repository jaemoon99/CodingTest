import java.util.Scanner;

public class Main {
    static int k;
    static int[] arr;
    static boolean[] v;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();

            if (k == 0) {
                return;
            }

            arr = new int[k];
            v = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }

            combination(0, 0);
            System.out.println();
        }
    }

    static void combination(int cnt, int start) {
        if (cnt == 6) {
            for (int i = 0; i < k; i++) {
                if (v[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            v[i] = true;
            combination(cnt + 1, i + 1);
            v[i] = false;
        }

    }
}