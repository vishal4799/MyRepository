import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetTest {
	static Set<String> s;
	static SortedSet<String> ss;
	public static void main(String[] args) {

	}
	public static Set<String> create(String [] arr){
		s = new HashSet<String>();
		for (int i = 0; i < arr.length; i++) {
			s.add(arr[i]);
		}
		return s;
	}
	
	public static SortedSet<String> createTreeSet(String [] arr){
		ss = new TreeSet<String>();
		for (int i = arr.length -1 ; i >= 0 ; i--) {
			ss.add(arr[i]);
		}
		return ss;
	}
	public static void printSortSet(){
		ss.forEach(k -> System.out.println(k));
	}
	
	public static void print(){
		s.forEach(e -> System.out.println(e));
	}
}
