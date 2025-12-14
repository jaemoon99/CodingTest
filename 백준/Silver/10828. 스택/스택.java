import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");

			switch (line[0]) {
				case "push": {
					stack.push(Integer.parseInt(line[1]));
					break;
				}
				case "pop": {
					if (!stack.isEmpty()) {
						System.out.println(stack.pop());
					} else {
						System.out.println(-1);
					}
					break;
				}
				case "size": {
					System.out.println(stack.size());
					break;
				}
				case "empty": {
					if (stack.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				}
				case "top": {
					if (!stack.isEmpty()) {
						System.out.println(stack.peek());
					} else {
						System.out.println(-1);
					}
					break;
				}
			}
		}

		br.close();
	}
}
