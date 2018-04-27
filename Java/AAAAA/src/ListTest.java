import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {
	static List<String> l;
	public static void main(String[] args) {
		String[] a = {"abc","pqr","xyz"};
		create(a); 
		print();
	}
	public static List<String> create(String [] arr){
//		l = new ArrayList<String>();
//		for (int i = 0; i < arr.length; i++) {
//			l.add(arr[i]);
//		}
//		return l;
		return l= Arrays.asList(arr);
	}
	
	public static void print(){
		l.forEach(e -> System.out.println(e));
		System.out.println(l.stream().map((e)->"'"+e+"'").collect(Collectors.toList()));
		StringBuilder dcids = new StringBuilder();
		int i=0;
		for(; i < l.size()-1; i++) {
			dcids.append("'"+l.get(i)+"',");
		}
		dcids.append("'"+l.get(i)+"'");
		System.out.println(dcids);
	}
}
