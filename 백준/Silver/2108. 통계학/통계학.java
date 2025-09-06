import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] freq = new int[8001];  // -4000 ~ 4000 (총 8001개)
        long sum = 0;
        int min = 4001, max = -4001;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
            freq[x + 4000]++;
            
            if (x < min) {
            	min = x;
            }
            
            if (x > max) {
            	max = x;
            }
        }

        sc.close();

        // 평균 (반올림)
        int mean = (int) Math.round((double) sum / n);

        // 중앙값
        int target = n / 2 + 1;
        int acc = 0;
        int median = 0;
        for (int v = min; v <= max; v++) {
            acc += freq[v + 4000];
            if (acc >= target) {
                median = v;
                break;
            }
        }

        // 최빈값 (개수가 같다면 두 번째로 작은 값)
        int maxFreq = 0;
        for (int v = min; v <= max; v++) {
            if (freq[v + 4000] > maxFreq) maxFreq = freq[v + 4000];
        }

        int mode = 0, seen = 0;
        for (int v = min; v <= max; v++) {
            if (freq[v + 4000] == maxFreq) {
                seen++;
                mode = v;
                
                if (seen == 2) {
                	break; // 두 번째 최빈값이면 멈춤
                }
            }
        }

        // 범위
        int range = max - min;

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}