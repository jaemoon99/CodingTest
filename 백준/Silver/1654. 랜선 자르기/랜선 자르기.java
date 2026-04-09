import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            lst.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(lst);

        long start = 1;
        long end = lst.get(lst.size() - 1);
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(mid, lst) >= n) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static long check(long mid, List<Integer> lst) {
        long answer = 0;

        for (Integer i : lst) {
            answer += i / mid;
        }

        return answer;
    }
}