
public class EquilibriumPointInArray {
	public static void main(String[] args) {
		//a[3] =2 and a[7]=0 both r 
		int a[] = {-7, 4, 1, 5, 2, -4, 3, 0, 1, 3};
		int sum = 0,lsum = 0, rsum;
		//soluation 1: for negative positive both the number
		System.out.println("For both negative and positive: complexity bestcase n ,avg worse 2n");
		for(int i : a){
			sum += i;
		}
		rsum = sum;
		for(int j=0; j < a.length; j++){
			rsum = sum -lsum - a[j];
			if(lsum == rsum){
				System.out.println(j+"::"+a[j]);
			}
			lsum += a[j];
		}
		//end solution1
		//soluation 2: for positive number only
		System.out.println("Only for positive:complexity bestcase 1 ,avg worse n");
		int rIndex = a.length -1;
		for(int j=0; j < a.length; j++){
			
			rsum = sum -lsum - a[j];
			if(lsum == rsum){
				System.out.println(j+"::"+a[j]);
			}
			lsum += a[j];
		}
	}

}
