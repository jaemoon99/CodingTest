import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			Deque<Integer> queue = new ArrayDeque<>();
			
			for (int i = 0; i < 8; i++) {				
				queue.offer(sc.nextInt());
			}
			
			int cnt = 1;
			while (true) {
				if (cnt > 5) {
					cnt = 1;
				}
				
				int num = queue.poll() - cnt;
				
				if (num <= 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(num);
					cnt++;
				}
			}
			
			int size = queue.size();
			System.out.print("#" + T);
			for (int i = 0; i < size; i++) {
				System.out.print(" " + queue.poll());
			}
            System.out.println();
		}
	}
}