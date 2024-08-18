import java.util.Scanner;

public class Main {
	
	// 소수 판별 함수
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	// 재귀적으로 소수를 찾는 함수
	public static void findPrime(int num, int n) {
		if (n == 0) {
			System.out.println(num);
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			int newNum = num * 10 + i;
			if (isPrime(newNum)) {
				findPrime(newNum, n - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 첫 자리 수를 2, 3, 5, 7로 시작하도록 함
		findPrime(2, N - 1);
		findPrime(3, N - 1);
		findPrime(5, N - 1);
		findPrime(7, N - 1);
	}
}
