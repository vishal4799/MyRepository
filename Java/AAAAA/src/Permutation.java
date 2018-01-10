
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc"; //length 3, total permutations are 3! = 1*2*2 = 6;
		Permutation.permutation(s, "");
	}
	
	public static void permutation(String s, String prefix){
		if(s.length() == 0){
			System.out.println(prefix);
		}
		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(0,i)+s.substring(i+1);
			permutation(temp, prefix+s.charAt(i));
		}
	}

}
