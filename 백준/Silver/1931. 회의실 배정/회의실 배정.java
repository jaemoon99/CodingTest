import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 회의 개수
		int n = sc.nextInt();
		// 전체 회의를 담을 배열
		ArrayList<int[]> mList = new ArrayList<>();
		
		// 회의 삽입
		for (int i = 0; i < n; i++) {
			mList.add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		
		// 끝나는 시간을 기준으로 정렬
		mList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
            	if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
		
		// 회의 개수를 카운트할 변수
        int count = 0;
        // 이 회의 끝나는 시간
        int endTime = 0;
        
        // 전체 회의 순회
        for (int i = 0; i < n ; i++) {
            // 이전 회의의 끝나는 시간보다 현재 회의의 시작 시간이 크거나 같은 경우
            if (endTime <= mList.get(i)[0]) {
                // 회의의 끝나는 시간을 갱신하고 회의 개수를 증가
                endTime = mList.get(i)[1];
                count++;
            }
        }
        // 결과 출력
        System.out.println(count);
	}
}
