import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] check = new int[20_000_001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			check[Integer.parseInt(st.nextToken()) + 10_000_000]++;
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		br.close();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(check[Integer.parseInt(st.nextToken()) + 10_000_000]).append(" ");
		}

		System.out.println(sb);
	}
}
