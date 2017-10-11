import java.util.HashMap;

public class hasCodeAndEquals {

	public static void main(String[] args) {
		//with String
		String str1 = "vishal";
		String str2 = "vishal";
		String str3 = new String("vishal");
		System.out.println("#code of str1:"+str1.hashCode());
		System.out.println("#code of str2:"+str2.hashCode());
		System.out.println("#code of str3:"+str3.hashCode());
		System.out.println("str1.equals(str2):"+str1.equals(str2));
		System.out.println("str1 == str2:"+ (str1 == str2));
		System.out.println("str3.equals(str2):"+str3.equals(str2));
		System.out.println("str3 == str2:"+ (str3 == str2));
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put(str2, 2);
		hm.put(str1, 1);
		hm.put(str3, 3);
		System.out.println(hm.get(str2));
		System.out.println(hm.toString());

		//with String
		
		A a1= new A("vishal");
		A a2= new A("vishal");
		System.out.println("\n#code of a1:"+a1.hashCode());
		System.out.println("#code of a2:"+a2.hashCode());
		//System.out.println("#code of str3:"+str3.hashCode());
		System.out.println("a1.equals(a2):"+a1.equals(a2));
		System.out.println("a1 == a2:"+ (a1 == a2));
		//System.out.println("str3.equals(str2):"+str3.equals(str2));
		//System.out.println("str3 == str2:"+ (str3 == str2));
		HashMap<A, Integer> hm2 = new HashMap<A, Integer>();
		hm2.put(a2, 2);
		hm2.put(a1, 1);
		//hm2.put(str3, 3);
		System.out.println(hm2.get(a2));
		System.out.println(hm2.toString());
	}

}

class A {
	String str;
	A(String s){
		str = s;
	}
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return str.hashCode();
//	}
//	public boolean equals(A obj) {
//		return str.equals(obj.str);
//	}
}