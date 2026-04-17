import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(input[i]);
		}

		int s = Integer.parseInt(br.readLine());

		for (int i = 0; i < n - 1 && s > 0; i++) {
			int moved = swap(a, i, s);
			s -= moved;
		}

		for (int ele : a) {
			System.out.print(ele + " ");
		}
	}

	static int swap(int[] a, int start, int s) {
		int maxIdx = start;

		for (int i = start + 1; i < a.length && i <= start + s; i++) {
			if (a[i] > a[maxIdx]) {
				maxIdx = i;
			}
		}

		if (maxIdx == start) {
			return 0;
		}

		int temp = a[maxIdx];
		for (int i = maxIdx; i > start; i--) {
			a[i] = a[i - 1];
		}
		a[start] = temp;

		return maxIdx - start;
	}
}