import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<int[]> classes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] classInfo = br.readLine().split(" ");
			int startTime = Integer.parseInt(classInfo[0]);
			int endTime = Integer.parseInt(classInfo[1]);
			classes.add(new int[] { startTime, endTime });
		}

		classes.sort((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}

			return a[0] - b[0];
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(classes.get(0)[1]);

		for (int i = 1; i < n; i++) {
			if (pq.peek() <= classes.get(i)[0]) {
				pq.poll();
			}

			pq.offer(classes.get(i)[1]);
		}

		System.out.println(pq.size());

	}
}
