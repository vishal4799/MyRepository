import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortHashMapByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortHashMapByValue s = new SortHashMapByValue();
		Map<String,Integer>	hm = new HashMap<>();
		hm.put("C",2);
		hm.put("B",1);
		hm.put("E",3);
		hm.put("A",5);
		hm.put("D",4);
		
		Map tMap = new TreeMap<String, Integer>(hm);
		System.out.println(tMap.toString());
	}

}
