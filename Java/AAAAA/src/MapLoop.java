import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapLoop {

	public static void main(String[] args) {

		// initial a Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Jan");
		map.put("2", "Feb");
		map.put("3", "Mar");
		map.put("4", "Apr");
		map.put("5", "May");
		map.put("6", "Jun");
		
		// Map -> Set -> Iterator -> Map.Entry -> troublesome, not recommend!
		System.out.println("\nExample 1...");
		Iterator<Entry<String, String>> i = map.entrySet().iterator();
		Entry<String, String> entry;
		while(i.hasNext()){
			entry = i.next();
			if(entry.getValue().charAt(0) == 'F'){
				i.remove();
			}
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}

		// more elegant way, this should be the standard way, recommend!
		System.out.println("\nExample 2...");
		for (Map.Entry<String, String> entri : map.entrySet()) {
			if(entri.getValue().charAt(0) == 'A'){
				entri.setValue("Aprill");
				//map.remove("5"); // java.util.ConcurrentModificationException
				map.put("6", "Junn");
			}
			System.out.println("Key : " + entri.getKey() + " Value : " + entri.getValue());
		}

		// weired, but works anyway, not recommend!
		System.out.println("\nExample 3...");
		for (Object key : map.keySet()) {
			System.out.println("Key : " + key.toString() + " Value : " + map.get(key));
		}

		//Java 8 only, forEach and Lambda. recommend!
		System.out.println("\nExample 4...");
		map.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));
	}

}