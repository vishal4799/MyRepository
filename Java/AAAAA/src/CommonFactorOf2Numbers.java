//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class CommonFactorOf2Numbers {
    int num1,num2;
    public static void main(String args[] ) throws Exception {
        CommonFactorOf2Numbers t = new CommonFactorOf2Numbers();
        int palindromicNum = t.nthPalindrome(Integer.parseInt("1000000"),2);
        System.out.println(palindromicNum);
        
        System.out.println(t.findLowestMostOccurrance(palindromicNum));

        
        // Write your code here

    }
    
    int findLowestMostOccurrance(int palindromicNum) {
    	String pNum = String.valueOf(palindromicNum);
    	String pNumCopy = new String(pNum);
    	Map<Integer, List<Character>> map = new HashMap<>();
    	int count, maxCount = 0;
    	List<Character> tempChars;
    	for (int j = 0; j < pNum.length(); j++) {
    		Character currChar = pNum.charAt(j);
    		count = countCharOccurance(currChar,pNumCopy);
    		if(count != 0 && count >= maxCount) {
    			if(map.containsKey(count)) {
    				map.get(count).add(currChar);
    			} else {
    				tempChars = new ArrayList<Character>();
    				tempChars.add(currChar);
    				map.put(count, tempChars);
    			}
    			pNumCopy.replaceAll(String.valueOf(currChar), "");
    			maxCount = count;
    		}
		}
    	
    	List<Character> chars = map.get(maxCount);
    	int lowestDigit = palindromicNum;
    	
    	for(Character c: chars) {
    		int currentDigit = Integer. parseInt(String. valueOf(c));
    		if(currentDigit < lowestDigit) {
    			lowestDigit = currentDigit;
    		}
    	}
    	return lowestDigit;
    }
    int countCharOccurance(Character c, String pNum) {
    	int count = 0;
    	for (int i = 0; i < pNum.length(); i++) {
    	    if (pNum.charAt(i) == c) {
    	        count++;
    	    }
    	}
    	return count;
    }
    
    int nthPalindrome(int n,int k)
    {
        // Get the smallest k digit number
        int num = (int)Math.pow(10, k-1);
     
        while (true)
        {
            // check the number is palindrom or not
            if (isPalindrom(num))
                --n;
     
            // if n'th palindrome found break the loop
            if (n <= 0)
                break;
     
            if(String.valueOf(num).length() > k) {
            	k +=2;
            	num = (int)Math.pow(10, k-1);
            }
            ++num;
        }
     
        return num;
    }
    
    boolean isPalindrom(int num)
    {
        return num == reverseNum(num);
    }
    
    int reverseNum(int n)
    {
        int rem, rev=0;
        while (n > 0)
        {
            rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    int execute2(int size, String input) {
    	String[] numbers = input.split(" ");
    	try {
//    		List<Integer> intList = new ArrayList<>();
//    		int num, sum = 0;
//    		for(String s : numbers) {
//    			num = Integer.valueOf(s);
//    			sum +=num;
//    			intList.add(num);
//    		}
//    		Collections.sort(intList);
//    		
//    		int prevSum = intList[intList.size()-1]*numbers.length;
//    		for (int i = numbers.length -2; i > -1 ; i--) {
//    			prevSum = size*i;
//				if(prevSum > sum && 
//				
//			}
	        return 0;
    	} catch(Exception e) {
    		return 0;
    	}
    }
    int execute(String input) {
    	String [] numbers = input.split(" ");
    	try {
    		int num1 = Integer.parseInt(numbers[0]);
    		int num2 = Integer.parseInt(numbers[1]);
    		Set<Integer> factor1 = calculateFactors(num1);
    		Set<Integer> factor2 = calculateFactors(num2);
    		factor1.retainAll(factor2);
    		return factor1.size();
    	} catch(Exception e) {
    		return 0;
    	}
    }
    Set<Integer> calculateFactors(int num){
    	int root = num;
    	Set<Integer> factors = new HashSet<>();
        for (int i = 1; root > 1 || root < -1 ; i++) {
			if(root%i == 0) {
				root = root/i;
				factors.add(i);
				factors.add(root);
				i = 1;
			}
		}
        System.out.println(factors.toString());
        return factors;
    }
}