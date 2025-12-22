import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] l = br.readLine().split(" ");
            map.put(l[0], l[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        br.close();

        System.out.println(sb);
    }
}