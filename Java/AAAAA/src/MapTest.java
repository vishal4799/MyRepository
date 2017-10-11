import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapTest {
	static Map<String, String> m;
	static SortedMap<String, String> sm;
	public static void main(String[] args) {

	}
	public static Map<String, String> create(String [] arr){
		m = new HashMap<String, String>();
		for (int i = 0; i < arr.length; i++) {
			m.put(i+"",arr[i]);
		}
		return m;
	}
	
	public static Map<String, String> createLinkedHashmap(String [] arr){
		m = new LinkedHashMap<String, String>();
		for (int i = arr.length -1 ; i >= 0 ; i--) {
			m.put(i+"",arr[i]);
		}
		return m;
	}
	public static SortedMap<String, String> createTreeMap(String [] arr){
		sm = new TreeMap<String, String>();
		for (int i = arr.length -1 ; i >= 0 ; i--) {
			sm.put(i+"",arr[i]);
		}
		return sm;
	}
	
	public static void print(){
		m.forEach((k,v) -> System.out.println(k+"::"+v));
	}
	public static void printSortMap(){
		sm.forEach((k,v) -> System.out.println(k+"::"+v));
	}
}
