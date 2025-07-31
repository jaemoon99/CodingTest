import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int nA = sc.nextInt();
        int nB = sc.nextInt();

        int[] A = new int[nA], B = new int[nB];
        for (int i = 0; i < nA; i++) A[i] = sc.nextInt();
        for (int i = 0; i < nB; i++) B[i] = sc.nextInt();
        sc.close();

        int[] psA = new int[2 * nA + 1], psB = new int[2 * nB + 1];
        for (int i = 1; i <= 2 * nA; i++)
            psA[i] = psA[i - 1] + A[(i - 1) % nA];
        for (int i = 1; i <= 2 * nB; i++)
            psB[i] = psB[i - 1] + B[(i - 1) % nB];

        List<Integer> sumA = new ArrayList<>(), sumB = new ArrayList<>();

        for (int len = 1; len < nA; len++)
            for (int st = 0; st < nA; st++)
                sumA.add(psA[st + len] - psA[st]);
        sumA.add(psA[nA]);

        for (int len = 1; len < nB; len++)
            for (int st = 0; st < nB; st++)
                sumB.add(psB[st + len] - psB[st]);
        sumB.add(psB[nB]);

        sumA.add(0);
        sumB.add(0);

        Collections.sort(sumB);

        long answer = 0;
        for (int x : sumA) {
            int need = T - x;
            int lb = lowerBound(sumB, need);
            int ub = upperBound(sumB, need);
            answer += (ub - lb);
        }

        System.out.println(answer);
    }

    private static int lowerBound(List<Integer> list, int key) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private static int upperBound(List<Integer> list, int key) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}