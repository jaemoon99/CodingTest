import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		int[] nums = new int[n];
		
		Map<Integer, Integer> maps = new HashMap<>();
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			
			sum += nums[i];
			
			if (!maps.containsKey(nums[i])) {
				maps.put(nums[i], 1);
			} else {
				maps.put(nums[i], maps.get(nums[i]) + 1);
			}
			
		}
		
		sc.close();
		
		Arrays.sort(nums);
		
		int check = 0;
		int cnt = 0;
		int value = 0;
		for (int num : nums) {
			if (value == num && maps.get(num) == cnt) {
				continue;
			}
			
			if (maps.get(num) > cnt) {
				cnt = maps.get(num);
				check = 1;
				value = num;
				continue;
			}
			
			if (check == 1 && maps.get(num) == cnt) {
				check = 0;
				value = num;
			}
		}
		
		System.out.println((int) Math.round((double) sum / n));
		System.out.println(nums[n / 2]);
		System.out.println(value);
		System.out.println(nums[n - 1] - nums[0]);
		
	}

}
