import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        int idx = 0;
        int start = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (idx < n) {
            if (start <= arr[idx]) {
                stack.push(start++);
                sb.append("+").append("\n");
                continue;
            }

            if (stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
                continue;
            }

            if (stack.peek() > arr[idx]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}