import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		int len = 1;

		while (k > (1 << len)) {
			k -= (1 << len);
			len++;
		}

		k--;

		StringBuilder sb = new StringBuilder();
		for (int i = len - 1; i >= 0; i--) {
			if ((k & (1 << i)) == 0) {
				sb.append('4');
			} else {
				sb.append('7');
			}
		}

		System.out.println(sb);
	}
}