import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> nn = new ArrayList<>();
        List<Integer> pn = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            
            if (x < 0) {
            	nn.add(-x);
            }
            
            else if (x > 0) {
            	pn.add(x);
            }
        }

        sc.close();

        Collections.sort(nn, Collections.reverseOrder());
        Collections.sort(pn, Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < nn.size(); i += m) {
        	result += nn.get(i) * 2;
        }
        
        for (int i = 0; i < pn.size(); i += m) {
        	result += pn.get(i) * 2;
        }

        int maxAbs = 0;
        if (!nn.isEmpty()) {
        	maxAbs = Math.max(maxAbs, nn.get(0));
        }
        
        if (!pn.isEmpty()) {
        	maxAbs = Math.max(maxAbs, pn.get(0));
        }
        
        result -= maxAbs;

        System.out.println(result);
    }
}