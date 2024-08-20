import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	
	static int max;
	static int min;
	static int n;
	static int[] nList;
	static String[] opr;
	static String[] sel;
	static boolean[] v;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			opr = new String[n - 1];
			sel = new String[n - 1];
			v = new boolean[n - 1];
			nList = new int[n];
			
			int oprIdx = 0;
			for (int i = 0; i < 4; i++) {
				int oprNum = sc.nextInt();
				for (int j = 0; j < oprNum; j++) {
					switch (i) {
						case 0:
							opr[oprIdx++] = "+";
							break;
						case 1:
							opr[oprIdx++] = "-";
							break;
						case 2:
							opr[oprIdx++] = "*";
							break;
						case 3:
							opr[oprIdx++] = "/";
							break;
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				nList[i] = sc.nextInt();
			}
			
			max = -100_000_000;
			min = 100_000_000;
			func(0);
			System.out.println("#" + tc + " " + (max - min));
		}
	}
	
	static void func(int cnt) {
		if (cnt == n - 1) {
			cal();
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!v[i]) {
                if (i > 0 && opr[i].equals(opr[i - 1]) && !v[i - 1]) {
                    continue;
                }
                sel[cnt] = opr[i];
                v[i] = true;
                func(cnt + 1);
                v[i] = false;
            }
        }
	}
	
	static void cal() {
		Deque<Object> queue = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			queue.offer(nList[i]);
			if (i < n - 1) {
				queue.offer(sel[i]);
			}
		}
		
		int pre = (int) queue.poll();
		
		while (!queue.isEmpty()) {
			Object poll = queue.poll();
			if (poll.equals("+")) {
				pre = pre + (int) queue.poll();
			} else if (poll.equals("-")) {
				pre = pre - (int) queue.poll();
			} else if (poll.equals("*")) {
				pre = pre * (int) queue.poll();
			} else if (poll.equals("/")) {
				pre = pre / (int) queue.poll();
			}
		}
		
		if (pre > max) {
			max = pre;
		}
		
		if (pre < min) {
			min = pre;
		}
	}
}
