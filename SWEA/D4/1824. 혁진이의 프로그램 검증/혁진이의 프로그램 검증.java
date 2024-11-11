import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static private int R, C;
	static private char[][] m;
	static private boolean isStop;
	static private boolean[][][][] visited;
	static private int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static private int[] dc = { 0, 0,-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 69개 테스트케이스
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			m = new char[R][];
			boolean isOk = false; // @ : 프로그램의 실행을 정지 가 있는지 판단
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				m[i] = s.toCharArray();
				if (!isOk && s.indexOf('@') >= 0) {
					isOk = true;
				}
			} // 입력 끝

			if (!isOk) { // @ : 프로그램의 실행을 정지 가 없으면, 정지불가
				sb.append("#").append(testCase).append(" NO\n");
				continue;
			}

			visited = new boolean[R][C][4][16];
			isStop = false;
			int num = 0;
			if (m[0][0] >= '0' && m[0][0] <= '9') {
				num = m[0][0] - '0';
			}
			dfs(0, 0, 3, num);
			sb.append("#").append(testCase).append(isStop ? " YES\n" : " NO\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	public static void dfs(int r, int c, int dir, int num) {
		if (isStop || m[r][c] == '@') { // 정지 
			isStop = true;
			return;
		}
		if (visited[r][c][dir][num]) return; // 방문한 정점이면 그만
		visited[r][c][dir][num] = true; // 방문체크

		char ch = m[r][c];
		if (ch == '?') { // ?  이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다. => 정지할 수 있는 방법이 하나라도 있으면 YES / 정지할 수 있는 방법이 전혀 없으면 NO
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if      (nr <  0) nr = R - 1;
				else if (nr >= R) nr = 0;
				else if (nc <  0) nc = C - 1;
				else if (nc >= C) nc = 0;
				if (visited[nr][nc][i][num]) continue;

				dfs(nr, nc, i, num);
				visited[nr][nc][dir][num] = false;
				if (isStop) return;
			}
		} else { // 방향설정후 한칸전진
			switch (ch) { // 방향설정
			case '^': //	^	이동 방향을 위쪽으로 바꾼다.
				dir = 0;
				break;
			case 'v': //	v	이동 방향을 아래쪽으로 바꾼다.
				dir = 1;
				break;
			case '<': //	<	이동 방향을 왼쪽으로 바꾼다
				dir = 2;
				break;
			case '>': //	>	이동 방향을 오른쪽으로 바꾼다.
				dir = 3;
				break;
			case '_': //	_	메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
				if (num == 0) dir = 3;
				else 		  dir = 2;
				break;
			case '|' : //	|	메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
				if (num == 0) dir = 1;
				else		  dir = 0;
				break;
			case '.': //	.	아무 것도 하지 않는다.
				break;
			case '+' : //	+	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
				num++;
				if (num > 15) num = 0;
				break;
			case '-' : //	-	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.
				num--;
				if (num < 0) num = 15;
				break;
			default :
				if ('0'<=ch && ch<='9') {
					num = ch - '0';
				}
				break;
			} // end of switch
			// 한칸 전진
			r += dr[dir];
			c += dc[dir];
			if      (r <  0) r = R-1;
			else if (r >= R) r = 0;
			else if (c <  0) c = C-1;
			else if (c >= C) c = 0;

			dfs(r, c, dir, num);
		}
	} // end of dfs()
} // end of class