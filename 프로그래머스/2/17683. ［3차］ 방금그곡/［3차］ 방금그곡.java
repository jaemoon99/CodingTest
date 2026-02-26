class Solution {
    public String solution(String m, String[] musicinfos) {
        m = m.replace("C#", "ㅊ").replace("D#", "ㅇ").replace("F#", "ㄹ")
             .replace("G#", "ㅎ").replace("A#", "ㅁ").replace("E#", "ㄷ").replace("B#", "ㅠ");

        String answer = "(None)";
        int bestTime = -1;

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");

            String[] s = split[0].split(":");
            int start = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);

            String[] e = split[1].split(":");
            int end = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);

            int time = end - start;
            String title = split[2];

            String info = split[3].replace("C#", "ㅊ").replace("D#", "ㅇ").replace("F#", "ㄹ")
                                   .replace("G#", "ㅎ").replace("A#", "ㅁ").replace("E#", "ㄷ").replace("B#", "ㅠ");

            StringBuilder played = new StringBuilder();
            int len = info.length();
            for (int i = 0; i < time; i++) {
                played.append(info.charAt(i % len));
            }

            if (played.indexOf(m) != -1) {
                if (time > bestTime) {
                    bestTime = time;
                    answer = title;
                }
            }
        }

        return answer;
    }
}