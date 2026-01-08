class Solution {

    int[] gInfo;
    int[][] gEdges;
    int maxSheepCnt = 0;

    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        boolean[] initVisited = new boolean[info.length];
        dfs(0, initVisited, 0, 0);

        return maxSheepCnt;
    }

    public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[idx] = true; // 방문처리
        if (gInfo[idx] == 0) { // 양이면
            sheepCnt++; // 양 증가
            maxSheepCnt = Math.max(maxSheepCnt, sheepCnt); // 최대값 갱신
        } else {
            wolfCnt++; // 늑대면 늑대 증가
        }

        if (sheepCnt <= wolfCnt) { // 양과 늑대 수가 같거나 늑대가 더 많은 경우
            return;
        }

        for (int[] edge : gEdges) { // 전체 노드 탐색
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisited = new boolean[visited.length];
				System.arraycopy(visited, 0, nextVisited, 0, visited.length); // 방문처리 복사
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt); // 방문한 노드의 자식들 중 방문하지 않은 다음 노드로 간다
            }
        }
    }
}