import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int result = Integer.MAX_VALUE, len;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		len = s.length();
		
		list = new ArrayList[26]; //문자마다 위치를 추가할 list 배열
		for(int i=0;i<26;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<len;i++) {
			char now = s.charAt(i);
			list[now - 'a'].add(i); //위치를 추가
		}
		
		dfs(0, 0, 0);

		System.out.println(result + len);

	}

	private static void dfs(int cnt, int idx, int move) {
		if(cnt == 26) {
			result = Math.min(result, move); // 최소 갱신
			return;
		}
		
		if(list[cnt].size() == 0) { //문자가 없으면 다음으로
			dfs(cnt+1, idx, move);
		} 
		// 하나 이상 존재할 경우
		else {
			int first = list[cnt].get(0); // 첫 번째 위치
			int last = list[cnt].get(list[cnt].size() - 1); // 마지막 위치
			
			if(first == last) { // 하나 들어 있는 경우
				move += Math.abs(idx - first);
				idx = first; // 위치 이동
				dfs(cnt + 1, idx, move);
			}
			else { // 여러개 들어 있는 경우
				int num1 = Math.abs(idx - first); // 첫번째 위치까지 거리
				int num2 = Math.abs(idx - last); // 마지막 위치까지 거리
				
				// 사이에 있는 경우
				if(idx > first && idx < last) { // idx가 둘 사이에 있을 때
					int temp = move + num1 * 2 + num2;
					dfs(cnt+1, last, temp); // 첫 -> 마
					
					temp = move + num1 + num2 * 2;
					dfs(cnt+1, first, temp); // 마 -> 첫
				}
				// 사이에 없는 경우
				else {
					if(num1 < num2) { //차이가 더 적은 쪽으로 이동
						move += num2; 
						idx = last;
					}
					else {
						move += num1;
						idx = first;
					}
					dfs(cnt + 1, idx, move);
				}
			}
		}
	}
}