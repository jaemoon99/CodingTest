import java.util.Scanner;

public class Main {

    static int n;
    static int k;
    static int result;
    static boolean[] v;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        v = new boolean[n];

        result = 0;
        combination(0, 0);
        System.out.println(result);
    }

    static void combination(int cnt, int start) {
        if (cnt == k) {
            result++;
            return;
        }

        for (int i = start; i < n; i++) {
            v[i] = true;
            combination(cnt + 1, i + 1);
            v[i] = false;
        }
    }
}
