import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(factorial(1,N));
    }
    static BigInteger factorial(int a,int n){
        BigInteger ret = BigInteger.valueOf(a);

        if(a<n){
            int b = (a+n)/2;
            ret = factorial(a,b).multiply(factorial(b+1,n));
        }
        return ret;
    }
}