import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<String> words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String word = sc.next();
			
			if (!words.contains(word)) { // 새로운 단어만 추
				words.add(word);
			}
		}
		
		sc.close();
		
		words.sort( // Comparator를 사용해 정렬
				Comparator.comparingInt(String::length) // 단어 길이가 짧은 순서대로 정렬
				.thenComparing(Comparator.naturalOrder()// 길이가 같으면 사전순으로 정렬
						)
				);
		
		for (String element : words) {
			System.out.println(element);
		}
	}
}
