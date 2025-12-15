import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        String startB = makeStartB(8);
        String startW = makeStartW(8);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i + 8 <= n; i++) {
            for (int j = 0; j + 8 <= m; j++) {
                int sB = 0;
                int sW = 0;

                for (int k = i; k < i + 8; k++) {
                    String rowW = ((k - i) % 2 == 0) ? startW : startB;
                    String rowB = ((k - i) % 2 == 0) ? startB : startW;

                    for (int l = j; l < j + 8; l++) {
                        int idx = l - j;
                        if (board[k][l] != rowW.charAt(idx)) sW++;
                        if (board[k][l] != rowB.charAt(idx)) sB++;
                    }
                }

                result = Math.min(result, Math.min(sB, sW));
            }
        }

        System.out.println(result);
    }

    static String makeStartB(int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) sb.append(i % 2 == 0 ? 'B' : 'W');
        return sb.toString();
    }

    static String makeStartW(int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) sb.append(i % 2 == 0 ? 'W' : 'B');
        return sb.toString();
    }
}