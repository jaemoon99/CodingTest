import java.util.*;

public class Main {

    static int n, map[] = new int[]{1, 5, 10, 50}, sel[];
    static Set<Integer> comSet = new HashSet<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sel = new int[n];

        com(0, 0);

        System.out.println(comSet.size());
        sc.close();
    }

    static void com(int start, int cnt) {
        if (cnt == n) {
            int sum = 0;
            for (int i : sel) {
                sum += map[i];
            }
            comSet.add(sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            sel[cnt] = i;
            com(i, cnt + 1);
        }
    }
}