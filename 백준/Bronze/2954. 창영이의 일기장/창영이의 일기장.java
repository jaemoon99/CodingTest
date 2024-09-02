import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        while (idx < input.length()) {
            char current = input.charAt(idx);
            
            // 모음일 때 'p'와 그 다음 동일한 모음이 나오는 경우 건너뛰기
            if (isVowel(current) && idx + 2 < input.length() && input.charAt(idx + 1) == 'p' && input.charAt(idx + 2) == current) {
                sb.append(current);  // 현재 모음을 추가
                idx += 3;  // 모음 + 'p' + 동일한 모음 패턴을 건너뜀
            } else {
                sb.append(current);  // 현재 문자를 추가
                idx++;  // 인덱스를 증가
            }
        }
        
        System.out.println(sb.toString());
    }

    // 모음인지 여부를 확인하는 메서드
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}