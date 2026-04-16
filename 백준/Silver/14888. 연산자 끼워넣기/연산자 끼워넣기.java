import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int n;
	static List<Integer> numbers = new ArrayList<>();
	static int[] signs = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		numbers = new ArrayList<>();
		String[] inputNumbers = br.readLine().split(" ");
		for (String number : inputNumbers) {
			numbers.add(Integer.parseInt(number));
		}

		String[] inputSigns = br.readLine().split(" ");
		for (int i = 0; i < signs.length; i++) {
			signs[i] = Integer.parseInt(inputSigns[i]);
		}

		br.close();

		dfs(1, numbers.get(0));

		System.out.println(max);
		System.out.println(min);

	}

	static void dfs(int idx, int current) {
		if (idx == n) {
			max = Math.max(max, current);
			min = Math.min(min, current);
			return;
		}

		int next = numbers.get(idx);

		if (signs[0] > 0) {
			signs[0]--;
			dfs(idx + 1, current + next);
			signs[0]++;
		}

		if (signs[1] > 0) {
			signs[1]--;
			dfs(idx + 1, current - next);
			signs[1]++;
		}

		if (signs[2] > 0) {
			signs[2]--;
			dfs(idx + 1, current * next);
			signs[2]++;
		}

		if (signs[3] > 0) {
			signs[3]--;
			dfs(idx + 1, current / next);
			signs[3]++;
		}
	}
}