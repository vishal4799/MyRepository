import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

@ClassPreamble(author = "vmakwana", date = "today", reviewers = { "Mohsin","Amit" })
public class Tests {
	public static void main(String[] args) throws Exception
    {
		System.out.println("*****************************HASHMAP");
		HashMap<String, String> hp = new HashMap<>();
		hp.put(null, null);
		hp.put(null, "1");
		hp.put("1", null);
		hp.put("2", "2");
		System.out.println(hp.toString());
		hp.forEach((k,v) ->{ if(k !=null)System.out.println(k+ "::"+v); });
		
		System.out.println("*****************************HASHTABLE");
		Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
		ht.put("0", 0);
		//ht.put(null, 1);//no null key allowed
		//ht.put("1", null);//no null value allowed
		ht.put("0", 2);
		System.out.println(ht.toString());
		ht.forEach((k,v) ->{ if(k !=null)System.out.println(k+ "::"+v); });
		
		System.out.println("*****************************HASHSET");
		HashSet<String> hs = new HashSet<>();
		hs.add("1");
		hs.add(null);
		hs.add("2");
		hs.add(null);
		hs.add("2");
		System.out.println(hs.toString());
    }
}
