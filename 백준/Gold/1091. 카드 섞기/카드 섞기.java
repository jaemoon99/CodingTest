import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
    static int N, cnt = 0, p[], s[], cards[], origins[];
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
        N = sc.nextInt();

        p = new int[N];
        s = new int[N];

        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
        }

        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = i;
        }
        origins = cards.clone();

        while (check() == false) {
            if (cnt != 0 && Arrays.equals(cards, origins)) {
                cnt = -1;
                break;
            }

            cnt += 1;
            shuffle();

        }

        System.out.println(cnt);
        
        sc.close();
    }

    public static void shuffle() {
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[s[i]] = cards[i];
        }
        cards = temp.clone();
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            int temp = cards[i];
            if (p[temp] != i % 3) {
                return false;
            }
        }
        return true;
    }
}