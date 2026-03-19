import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalMap = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String car = split[1];
            String type = split[2];

            int minute = calMinute(time);

            totalMap.putIfAbsent(car, 0);

            if (type.equals("IN")) {
                inMap.put(car, minute);
            } else {
                int inTime = inMap.remove(car);
                totalMap.put(car, totalMap.get(car) + (minute - inTime));
            }
        }

        int endTime = calMinute("23:59");
        for (String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            totalMap.put(car, totalMap.get(car) + (endTime - inTime));
        }

        int[] answer = new int[totalMap.size()];
        int idx = 0;

        for (String car : totalMap.keySet()) {
            int totalTime = totalMap.get(car);
            int fee = fees[1];

            if (totalTime > fees[0]) {
                int extra = totalTime - fees[0];
                fee += ((extra + fees[2] - 1) / fees[2]) * fees[3];
            }

            answer[idx++] = fee;
        }

        return answer;
    }

    private int calMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}