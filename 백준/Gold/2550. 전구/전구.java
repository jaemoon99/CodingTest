import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] s = new int[n];
        int[] l = new int[n];

        for (int i = 0; i < n; i++) s[i] = sc.nextInt();
        for (int i = 0; i < n; i++) l[i] = sc.nextInt();
        sc.close();

        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) pos.put(l[i], i);

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = pos.get(s[i]);

        int[] tails = new int[n];
        int[] tailsIdx = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        int len = 0;
        int lastIdx = -1;

        for (int i = 0; i < n; i++) {
            int x = a[i];
            int lo = 0, hi = len;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails[mid] < x) lo = mid + 1;
                else hi = mid;
            }
            int p = lo;

            tails[p] = x;
            tailsIdx[p] = i;

            if (p > 0) prev[i] = tailsIdx[p - 1];
            else prev[i] = -1;

            if (p == len) {
                len++;
                lastIdx = i;
            }
        }

        List<Integer> picked = new ArrayList<>();
        int cur = lastIdx;
        while (cur != -1) {
            picked.add(s[cur]);
            cur = prev[cur];
        }
        Collections.sort(picked);

        StringBuilder sb = new StringBuilder();
        sb.append(picked.size()).append('\n');
        for (int i = 0; i < picked.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(picked.get(i));
        }
        System.out.println(sb.toString());
    }
}