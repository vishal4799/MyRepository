
public class PrimeNumber {
	
	public static void main(String[] args){
		for (int i = 0; i < 101; i++) {
			if(PrimeNumber.isPrime(i))
				System.out.println(i);
		}
		
    }
	
	public static boolean isPrime(int n){
		for (int i = 2; i*i <= n ; i++) {
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
}
