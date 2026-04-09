import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (a == 1) {
                System.out.println(1);
                continue;
            }

            int answer = 1;
            for (int j = 0; j < b; j++) {
                answer = answer * a % 10;
            }

            if (answer == 0) {
                answer = 10;
            }

            System.out.println(answer);
        }

        br.close();

    }
}