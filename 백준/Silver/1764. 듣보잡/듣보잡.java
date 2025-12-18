import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, 1);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (!map.containsKey(name)) {
                map.put(name, 1);
                continue;
            }

            map.put(name, map.get(name) + 1);
        }

        br.close();

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (String name : map.keySet()) {
            if (map.get(name) == 2) {
                sb.append(name).append("\n");
                cnt++;
            }
        }

        System.out.println(sb.insert(0, "\n").insert(0, cnt));

    }
}