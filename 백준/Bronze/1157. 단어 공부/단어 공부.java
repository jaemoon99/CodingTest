import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey("" + str.charAt(i))){
                map.put(str.charAt(i) + "", map.get(str.charAt(i) + "") + 1);
            } else {
                map.put(str.charAt(i) + "", 1);
            }
        }

        int max = 0;
        int check = 0;
        String result = "";
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
                check = 1;
                result = s;
            } else if (map.get(s) == max) {
                check++;
            }
        }

        if (check > 1) {
            System.out.println("?");
        } else {
            System.out.println(result);
        }
    }
}