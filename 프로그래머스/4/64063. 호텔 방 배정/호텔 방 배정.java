import java.util.HashMap;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        HashMap<Long, Long> map = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {
            long number = room_number[i];
            answer[i] = findRoom(map, number);
        }

        return answer;
    }

    private long findRoom(HashMap<Long, Long> map, long number) {

        if (!map.containsKey(number)) {
            map.put(number, number + 1);
            return number;
        }

        long nextRoom = findRoom(map, map.get(number));
        map.put(number, nextRoom);
        return nextRoom;
    }
}