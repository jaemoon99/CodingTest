import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시각 기준 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // 소요시간
            return a[0] - b[0];                   // 요청시각(동률 처리)
        });

        int time = 0;
        int idx = 0;
        int total = 0;
        int n = jobs.length;

        while (idx < n || !pq.isEmpty()) {

            // 현재 time까지 도착한 작업을 pq에 넣기
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }

            // 처리할 게 없으면 다음 작업 도착 시각으로 점프
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }

            int[] job = pq.poll();
            time += job[1];
            total += time - job[0];
        }

        return total / n;
    }
}