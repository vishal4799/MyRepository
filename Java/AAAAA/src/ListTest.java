import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
	static List<String> l;
	public static void main(String[] args) {

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
	}
}
