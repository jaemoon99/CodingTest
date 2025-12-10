import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] names = new String[n];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->  {
			if (o1[1] != o2[1]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			names[i] = st.nextToken();
		}

		br.close();

		while (!pq.isEmpty()) {
			int[] poll =  pq.poll();
			System.out.println(poll[1] + " " + names[poll[0]]);
		}
	}
}
