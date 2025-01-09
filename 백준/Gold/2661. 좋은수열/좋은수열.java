import java.util.*;

public class Main {

    static int n;
    static boolean check = false;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dfs("");

        sc.close();
    }

    static void dfs(String per) {
        if (check) return;

        if (per.length() == n) {
            System.out.println(per);
            check = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (check(per + i)) {
                dfs(per + i);
            }
        }
    }

    static boolean check(String per) {
        int len = per.length();

        // 길이 1부터 len/2까지 인접한 부분수열 비교
        for (int k = 1; k <= len / 2; k++) {
            String pre = per.substring(len - k - k, len - k); // 앞부분
            String next = per.substring(len - k);             // 뒷부분

            if (pre.equals(next)) {
                return false;  // 동일한 부분수열이 존재하면 좋은 수열이 아님
            }
        }
        return true;
    }
}
