/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 */

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class PayPal2dQuestion {
    public static void main(String args[] ) throws Exception {

        PayPal2dQuestion t = new PayPal2dQuestion(); 
    	char[][] char2d = {{'*','.','.','*'},{'.','*','*','*'},{'*','*','*','*'},{'.','*','*','*'}};
        //Scanner
//        Scanner s = new Scanner(System.in);
//        String input = s.nextLine();
//        int n = Integer.parseInt(input.split(" ")[0]);                 // Reading input from STDIN
//        int m = Integer.parseInt(input.split(" ")[1]);  
//        char2D = new char[n][m];
//        for (int i = 0; i < n; i++) {
//        	char2D[i] = s.nextLine().substring(0, m).toCharArray();
//		}
//        int questions =Integer.parseInt(s.nextLine());
//        for (int i = 0; i < questions; i++) {
//			t.answer(Integer.parseInt(s.nextLine()));
//		}
    	System.out.println(t.answer(2, char2d));
    	
    }
    int answer(int q, char[][] char2d) {
    	int count = 0;
    	boolean isValid = true;
    	for (int i = 0; i < char2d.length-q+1; i++) {
			for (int j = 0; j <= char2d[i].length-q; j++) {
				isValid = true;
				for(int k = 0; k < q; k++) {
					if(!checkTrees(Arrays.copyOfRange(char2d[i+k], j, j+q))){
						isValid = false;
						break;
					}
				}
				if(isValid) {
					count++;
				}
			}
		}
    	return count;
    }
    boolean checkTrees(char[] chars) {
    	for (int i = 0; i < chars.length; i++) {
			if(chars[i] != '*') {
				return false;
			}
		}
    	return true;
    }
}
