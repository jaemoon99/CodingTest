import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, 1);
        }

        Map<String, Integer> sortMap = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                sortMap.put(name, 1);
            }
        }

        br.close();

        StringBuilder sb = new StringBuilder();
        sb.append(sortMap.size()).append("\n");
        for (String name : sortMap.keySet()) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);

    }
}