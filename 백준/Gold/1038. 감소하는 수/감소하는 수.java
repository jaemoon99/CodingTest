import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n > 1022) {
            System.out.println(-1);
            return;
        }

        Deque<Long> queue = new ArrayDeque<>();
        for (long i = 0; i <= 9; i++) {
            queue.offer(i);
        }

        int count = -1; // 감소하는 수의 순서
        long result = 0; // N번째 감소하는 수

        while (!queue.isEmpty()) {
            result = queue.poll();
            count++;

            if (count == n) {  // N번째 감소하는 수를 찾으면 출력하고 종료
                System.out.println(result);
                return;
            }

            // 현재 숫자의 마지막 자릿수보다 작은 숫자를 추가
            long last = result % 10;  // 마지막 자릿수
            for (long i = 0; i < last; i++) {
                queue.offer(result * 10 + i);
            }
        }
    }
}
