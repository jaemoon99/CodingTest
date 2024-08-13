import java.util.Scanner;


public class Main {
    static int N;
    static int M;
    static int[] map;
    static int[] sel;
    static int[] v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N];
        sel = new int[M];
        v = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = i + 1;
        }

        dfs(0);
    }

    static void dfs(int idx) {
        // 종료
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i] == 1) {
                continue;
            }

            sel[idx] = map[i];
            v[i] = 1;
            dfs(idx + 1);
            v[i] = 0;
        }
    }
}