import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        int cnt = 1;

        while (b > a) {
            if (b % 10 == 1) {
            	b /= 10;
            }
            
            else if (b % 2 == 0) {
            	b /= 2;
            }
            
            else { 
            	cnt = -1; break;
            }
            
            cnt++;
        }
        System.out.println(b == a ? cnt : -1);
        
        sc.close();
    }

}
