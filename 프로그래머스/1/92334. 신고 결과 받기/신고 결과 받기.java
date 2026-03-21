import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    class User {
        int id;
        Set<String> reporter;
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportMap = new HashMap<>();

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            User user = new User();
            user.id = i;
            user.reporter = new HashSet<>();
            userList.add(user);

            reportMap.put(id_list[i], i);
        }

        for (String r : report) {
            String[] split = r.split(" ");

            int userIdx = reportMap.get(split[1]);
            if (!userList.get(userIdx).reporter.contains(split[0])) {
                userList.get(userIdx).reporter.add(split[0]);
            }
        }

        for (User user : userList) {
            if (user.reporter.size() >= k) {
                for (String reporter : user.reporter) {
                    answer[reportMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}