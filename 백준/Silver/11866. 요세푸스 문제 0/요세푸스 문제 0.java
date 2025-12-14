import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
		
		br.close();
		
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        List<Integer> lst = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lst.add(i);
        }

        int idx = 0;
        List<Integer> result = new ArrayList<>();
        while (!lst.isEmpty()) {
            idx = (idx + k - 1) % lst.size();
            result.add(lst.remove(idx));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));

            if (i != result.size() - 1) {
				sb.append(", ");
			}
        }
        sb.append(">");

        System.out.println(sb);
    }
}
