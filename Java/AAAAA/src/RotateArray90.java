//	[1,2]
//	[3,4]
//	=>
//	[3,1]
//	[4,2]
public class RotateArray90 {
	//5*5
	static int[][] a = {{11,12,13,14,15},
						{26,31,32,33,16},
						{25,38,50,34,17},
						{24,37,36,35,18},
						{23,22,21,20,19}};
	//6*6
//	static int[][] a = {{11,12,13,14,15,10},
//						{26,31,32,33,16,10},
//						{25,38,50,34,17,10},
//						{24,37,36,35,18,10},
//						{23,22,21,20,19,10},
//						{10,10,10,10,10,10}};
	
	//just for debugging
	static int[][] b = {{00,00,00,00,00,00},
						{00,00,00,00,00,00},
						{00,00,00,00,00,00},
						{00,00,00,00,00,00},
						{00,00,00,00,00,00},
						{00,00,00,00,00,00}};
	
	public static void main(String[] args) {
		RotateArray90 r = new RotateArray90();
		for(int[] i:a){
			System.out.println();
			for(int j:i){
	            System.out.print(j);
	            System.out.print(" ");
			}
        }
		r.rotateArray(a);
		print(a);
	}
	static void print(int a[][]){
		System.out.print("\n==========");
		for(int[] i:a){
			System.out.println();
			for(int j:i){
				if(j == 0)System.out.print(" "); 
	            System.out.print(j);
	            System.out.print(" ");
			}
        }
	}

	void rotateArray(int a[][]){
	    int temp,temp2;
	
	    if(a != null){
	        int len = a.length;    
	        if(len > 1 && a[0].length > 1 && len == a[0].length){
	            int li;
	            for(int i = 0; i < len/2; i++){
	            	//System.out.print("\n==========I:"+i);
	            	li = len -1 -i;
	                for(int j = i, k = 0; j < li; j++, k++){
	                	int[][] aa = getB();
	                	//System.out.print("\n==========J:"+j);
	                    					temp = a[j][li];
	                    a[j][li] = a[i][j];aa[j][li] = a[i][j];
	                    					temp2 = a[li][li-k];
	                    a[li][li-k] = temp;aa[li][li-k] = temp;
	                    					temp = a[li-k][i];
	                    a[li-k][i] = temp2;aa[li-k][i] = temp2;
	                    a[i][j] = temp;aa[i][j] = temp;
	                    //print(aa);print(a);
	                    
	                }
	                
	            }
	        }
	    }
	}
	int [][] getB (){
		return b;
	}
}
