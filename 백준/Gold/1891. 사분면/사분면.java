import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();       // 문자열 길이
        String s = sc.next();       // 사분면 번호 문자열

        long dx = sc.nextLong();    // 이동 (x 방향)
        long dy = sc.nextLong();    // 이동 (y 방향)

        sc.close();

        long size = 1L << d; // 전체 격자 크기 = 2^d

        // 1) 문자열 -> 좌표
        long x = 0, y = 0;
        long len = size;
        for (int i = 0; i < d; i++) {
            len /= 2; // 현재 사각형을 4등분한 크기
            char c = s.charAt(i);
            if (c == '1') {         // 오른쪽 위
                x += len; y += len;
            } else if (c == '2') {  // 왼쪽 위
                y += len;
            } else if (c == '3') {  // 왼쪽 아래
                // 변화 없음
            } else if (c == '4') {  // 오른쪽 아래
                x += len;
            }
        }

        // 2) 이동
        x += dx;
        y += dy;

        // 3) 범위 벗어나면 -1
        if (x < 0 || y < 0 || x >= size || y >= size) {
            System.out.println(-1);
            return;
        }

        // 4) 좌표 -> 문자열
        StringBuilder ans = new StringBuilder();
        long cx = 0, cy = 0;
        len = size;
        for (int i = 0; i < d; i++) {
            len /= 2;
            if (x >= cx + len && y >= cy + len) {
                ans.append('1');
                cx += len; cy += len;
            } else if (x < cx + len && y >= cy + len) {
                ans.append('2');
                cy += len;
            } else if (x < cx + len && y < cy + len) {
                ans.append('3');
            } else {
                ans.append('4');
                cx += len;
            }
        }

        System.out.println(ans.toString());
    }
}