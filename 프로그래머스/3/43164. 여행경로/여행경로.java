import java.util.*;

class Solution {
    String[] answer;
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) {
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });

        answer = new String[tickets.length + 1];
        visited = new boolean[tickets.length];

        answer[0] = "ICN";
        dfs("ICN", tickets, 0);

        return answer;
    }

    public boolean dfs(String cur, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                answer[depth + 1] = tickets[i][1];

                if (dfs(tickets[i][1], tickets, depth + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}