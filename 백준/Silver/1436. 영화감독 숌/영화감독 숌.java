import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String containStr = "666";

		int idx = 0;
		int num = 666;
		while (idx != n) {

			if ((num + "").contains(containStr)) {
				idx++;
			}

			num++;
		}

		System.out.println(num - 1);
	}
}
