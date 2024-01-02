import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] p = {sc.nextLong(), sc.nextLong(), sc.nextLong(), sc.nextLong()};

        long x = sc.nextLong();
        long y = sc.nextLong();
        long r = sc.nextLong();

        for (int i = 0; i < p.length; i++) {
            if (p[i] == x || x - r == p[i] || x + r == p[i]) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);

        sc.close();
    }
}