
public class EquilibriumIndexInArray {

	public static void main(String[] args) {
		int [] arr = {-7,4,1,5,2,-4,3,0, 4};
		int sum = 0, lsum=0, rsum;
		for (int i : arr) {
			sum += i;
		}
		System.out.println(sum);
		
		for(int j = 0 ; j < arr.length-1; j++){
			lsum += arr[j];
			
			if(lsum == sum-lsum-arr[j+1]){
				System.out.println((j+1)+"::"+arr[j+1]);
				//break;
			}
		}
	}

}
