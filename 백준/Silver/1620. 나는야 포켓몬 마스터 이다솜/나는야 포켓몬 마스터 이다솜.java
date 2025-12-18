import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Map<String, Integer> map = new HashMap<>();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, i + 1);
            lst.add(name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            if ('9' >= input.charAt(0) && input.charAt(0) >= '1') {
                sb.append(lst.get(Integer.parseInt(input) - 1)).append("\n");
                continue;
            }

            sb.append(map.get(input)).append("\n");
        }

        br.close();

        System.out.println(sb);
    }
}