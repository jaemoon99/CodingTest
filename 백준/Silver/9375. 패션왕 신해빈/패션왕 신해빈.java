import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n =  Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] cloths = br.readLine().split(" ");

                if (map.containsKey(cloths[1])) {
                    map.put(cloths[1], map.get(cloths[1]) + 1);
                    continue;
                }

                map.put(cloths[1], 1);
            }

            if (map.size() == 1) {
                System.out.println(n);
                continue;
            }

            int total = 1;
            for (Integer value : map.values()) {
                total *= (value + 1);
            }

            System.out.println(total - 1);
        }

        br.close();
    }
}