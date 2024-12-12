import java.util.Scanner;

public class Main {

    static int n, k, sel[], v[], status[][];
    static String[] map;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new String[n];
        sel = new int[3];
        status = new int[n][2];
        v = new int[10];  // 숫자 1부터 9까지 사용, 0은 사용되지 않음

        for (int i = 0; i < n; i++) {
            map[i] = sc.next();
            status[i][0] = sc.nextInt(); // 스트라이크 수
            status[i][1] = sc.nextInt(); // 볼 수
        }

        per(0);

        System.out.println(result);
        sc.close();
    }

    static void per(int cnt) {
        if (cnt == 3) {
            // 생성된 숫자(sel 배열)가 주어진 조건을 모두 만족하는지 검사
            for (int i = 0; i < n; i++) {
                String temp = map[i];
                int strike = 0;
                int ball = 0;

                // 스트라이크 계산
                for (int j = 0; j < 3; j++) {
                    if (temp.charAt(j) - '0' == sel[j]) {
                        strike++;
                    }
                }

                // 볼 계산
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j != k && temp.charAt(j) - '0' == sel[k]) {
                            ball++;
                        }
                    }
                }

                // 주어진 조건과 맞지 않으면 해당 숫자는 후보가 아님
                if (strike != status[i][0] || ball != status[i][1]) {
                    return;
                }
            }
            // 조건을 만족하는 숫자라면 결과를 증가
            result++;
            return;
        }

        // 숫자 선택
        for (int i = 1; i <= 9; i++) {
            if (v[i] == 0) {
                v[i] = 1;  // 숫자 i를 선택했다고 표시
                sel[cnt] = i; // sel 배열에 현재 숫자 추가
                per(cnt + 1); // 다음 자리로 넘어감
                v[i] = 0;  // 선택한 숫자를 다시 사용할 수 있도록 표시
            }
        }
    }
}
