class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {

        if (play_time.equals(adv_time)) {
            return "00:00:00";
        }

        int play = calTimeTable(play_time);
        int adv = calTimeTable(adv_time);

        int[] timeTable = new int[play];

        for (String log : logs) {
            String[] split = log.split("-");
            int start = calTimeTable(split[0]);
            int end = calTimeTable(split[1]);

            for (int i = start; i < end; i++) {
                timeTable[i]++;
            }
        }

        int maxIdx=0;
        long maxSum=0;
        long sum =0;

        for(int i = 0; i < adv; i++) {
            sum += timeTable[i];
        }

        maxSum = sum;

        for(int i = adv; i < play; i++) {
            sum += timeTable[i] - timeTable[i - adv];
            if(sum > maxSum) {
                maxSum = sum;
                maxIdx = i-adv + 1;
            }
        }

        return timeToString(maxIdx);
    }

    public int calTimeTable(String play_time) {
        int totalTime = 0;

        String[] split = play_time.split(":");
        totalTime += Integer.parseInt(split[0]) * 3600;
        totalTime += Integer.parseInt(split[1]) * 60;
        totalTime += Integer.parseInt(split[2]);

        return totalTime;
    }

    public String timeToString(int time) {
        return String.format("%02d:%02d:%02d", time / 3600, (time % 3600) / 60, time % 60);
    }
}