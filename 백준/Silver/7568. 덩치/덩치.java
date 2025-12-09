import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new int[] {x, y});
		}

		br.close();

		for (int i = 0; i < list.size(); i++) {
			int cnt = 0;
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					if (list.get(j)[0] > list.get(i)[0] && list.get(j)[1] > list.get(i)[1]) {
						cnt++;
					}
				}
			}
			System.out.print(cnt + 1 + " ");
		}
	}
}
