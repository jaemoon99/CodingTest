import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] answerList = {0, 0, 0, 0, 0};
            int num = scanner.nextInt();
            while (true) {
                if (num % 11 == 0) {
                    answerList[4]++;
                    num /= 11;
                } else if (num % 7 == 0) {
                    answerList[3]++;
                    num /= 7;
                } else if (num % 5 == 0) {
                    answerList[2]++;
                    num /= 5;
                } else if (num % 3 == 0) {
                    answerList[1]++;
                    num /= 3;
                } else if (num % 2 == 0) {
                    answerList[0]++;
                    num /= 2;
                } else {
                    System.out.printf("#%d %d %d %d %d %d\n", test_case, answerList[0], answerList[1], answerList[2], answerList[3], answerList[4]);
                    break;
                }
            }
        }
	}
}