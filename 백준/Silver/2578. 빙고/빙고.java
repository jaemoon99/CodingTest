import java.util.Scanner;

public class Main {

	static int map[][], v[][];
    public static void main(String[] args) {
		
    	Scanner sc = new Scanner(System.in);
    	
    	map = new int[5][5];
    	v = new int[5][5];
    	
    	for (int i = 0; i < 5; i++) {
    		for (int j = 0; j < 5; j++) {
    			map[i][j] = sc.nextInt();
    		}
    	}
    	
    	for (int i = 0; i < 25; i++) {
    		int num = sc.nextInt();
    		
    		for (int j = 0; j < 5; j++) {
        		for (int k = 0; k < 5; k++) {
        			if (map[j][k] == num) {
        				v[j][k] = 1;
        				
        				if (i >= 1) {
        					int line = checkRows() + checkColumns() + checkCrossXs();
        					
        					if (line >= 3) {
        						System.out.println(i + 1);
        						
        						sc.close();
        						return;
        					}
        				}
        			}
        		}
        	}
    	}
	}
    
    static int checkRows() {
    	int line = 0;
    	
    	for (int i = 0; i < 5; i++) {
    		int check = 0;
    		for (int j = 0; j < 5; j++) {
    			if (v[i][j] == 1) {
    				check++;
    			}
    		}
    		
    		if (check == 5) {
    			line++;
    		}
    	}
    	
    	return line;
    }
    
    static int checkColumns() {
    	int line = 0;
    	
    	for (int i = 0; i < 5; i++) {
    		int check = 0;
    		for (int j = 0; j < 5; j++) {
    			if (v[j][i] == 1) {
    				check++;
    			}
    		}
    		
    		if (check == 5) {
    			line++;
    		}
    	}
    	
    	return line;
    }
    
    static int checkCrossXs() {
    	int line = 0;
    	int[] check = new int[2];
    	int idx = 4;
    	
    	for (int i = 0; i < 5; i++) {
    		if (v[i][i] == 1) {
    			check[0]++;
    		}
    		
    		if (v[i][idx] == 1) {
    			check[1]++;
    		}
    		idx--;
    	}
    	
    	for (int i = 0; i < 2; i++) {
    		if (check[i] == 5) {
    			line++;
    		}
    	}
    	
    	return line;
    }
}
