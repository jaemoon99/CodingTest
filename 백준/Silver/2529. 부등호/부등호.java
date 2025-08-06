import java.util.Scanner;

public class Main {

	static int k;
    static char[] signs;
    static boolean[] used = new boolean[10];
    static int[] arr;
    static String max = "";
    static String min = "";

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        k = sc.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }
        
        arr = new int[k + 1];
        dfs(0);
        
        System.out.println(max);
        System.out.println(min);
        
        sc.close();
    }

    private static void dfs(int depth) {
        if (depth == k + 1) {
            String sum = "";
            for (int num : arr) {
                sum += num;
            }
            
            if (min.equals("") || min.compareTo(sum) > 0) {
                min = sum;
            }
            
            if (max.equals("") || max.compareTo(sum) < 0) {
                max = sum;
            }
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                if (depth == 0 || check(arr[depth - 1], i, signs[depth - 1])) {
                    used[i] = true;
                    arr[depth] = i;
                    dfs(depth + 1);
                    used[i] = false;
                }
            }
        }   
    }
    
    private static boolean check(int a, int b, char sign) {
        if (sign == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}
