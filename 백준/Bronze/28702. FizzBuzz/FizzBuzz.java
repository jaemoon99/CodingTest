import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int findNum = 0;
		for (int i = 0; i < 3; i++)	{
			String line = br.readLine();

			if (line.charAt(0) != 'F' && line.charAt(0) != 'B') {
				findNum = Integer.parseInt(line) + 3 - i;
				break;
			}
		}

		br.close();

		if (findNum % 3 == 0 && findNum % 5 == 0){
			System.out.println("FizzBuzz");
			return;
		}

		if (findNum % 3 == 0){
			System.out.println("Fizz");
			return;
		}

		if (findNum % 5 == 0){
			System.out.println("Buzz");
			return;
		}

		System.out.println(findNum);
	}
}
