import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
class MyUtilities
{
    public static String mimicObjectToString(Object o)
    {
        //prevent a NullPointerException by returning null if o is null
    	String result = null;
        if (o !=null)
        {
            result = o.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(o));
        }
        return  result;
    }
}
  
  
public class Main
{
    public static void main(String[] args) throws Exception
    {
    	String REGEX_SPECIAL_CHAR = "[a-zA-Z0-9]*";
    	System.out.println("RegEX::"+ "SMALl vishal23432".matches(REGEX_SPECIAL_CHAR));
//    	System.out.println("authToken _c801337d-c192-46d3-9a95-b46bda395228");
//    	Object[] arg =Stream.of("authToken _c801337d-c192-46d3-9a95-b46bda395228").toArray();
//    	for (Object object : arg) {
//			System.out.println(object+"::");
//		}
//    	System.out.println(Stream.of("authToken _c801337d-c192-46d3-9a95-b46bda395228").toArray().toString());
//    	System.out.println(args.toString());
//    	System.out.println("authToken _c801337d-c192-46d3-9a95-b46bda395228".substring(10));
//    	System.out.println((1215%1134)%(513%(1215%1134)));
    	System.exit(0);
    	String [] st = " GMT+00:00 Africa/Abidjan, GMT-01:00 Africa/Accra, GMT+03:00 Africa/Addis_Ababa, GMT-02:00 Africa/Algiers, GMT+03:00 Africa/Asmara, GMT 00:00 Africa/Asmera, GMT+00:00 Africa/Bamako, GMT+01:00 Africa/Bangui, GMT+00:00 Africa/Banjul, GMT+00:00 Africa/Bissau, GMT 00:30 Africa/Blantyre, GMT+01:00 Africa/Brazzaville, GMT+02:00 Africa/Bujumbura, GMT+02:00 Africa/Cairo, GMT-00:30 Africa/Casablanca".split(",");
    	List<String> timezoneList = Arrays.asList(st);
//    	for (String tz : timezoneList){
//    		System.out.println(tz);
//    	}
    	List<String> plusTZ = new ArrayList<String>();
    	List<String> minusTZ = new ArrayList<String>();
    	
		for(String tz : timezoneList){
			if(tz.charAt(4) ==  '-'){
				minusTZ.add(tz);
			} else {
				plusTZ.add(tz);
			}
		}
		System.out.println("********************************");
    	for (String tz : timezoneList){
    		System.out.println(tz);
    	}
		Collections.sort(minusTZ, Collections.reverseOrder());
		System.out.println("*************minus*******************");
    	for (String tz : minusTZ){
    		System.out.println(tz);
    	}
		Collections.sort(plusTZ, null);
		System.out.println("*************plus*******************");
    	for (String tz : plusTZ){
    		System.out.println(tz);
    	}
    	timezoneList = minusTZ;
		timezoneList.addAll(plusTZ);
    	
    	System.out.println("********************************");
    	for (String tz : timezoneList){
    		System.out.println(tz);
    	}
    	System.out.println("********************************");
//    	AESEncryptor a= new AESEncryptor();
//    	
//        String s = "foo";
//        System.out.println(a.encrypt("bmcAdm1n"));
//        System.out.println(a.encrypt("2486656"));
//        System.out.println(a.encrypt("Ub/zoNW2RNrSbDSwDJKQCg=="));
    	StringBuilder incorrectTemplates = new StringBuilder();
    	incorrectTemplates.append("vishal");
    	System.out.println("check:::::::::");
    	
    	
    	
    	
        System.out.println("check:"+ incorrectTemplates.length());
//        System.out.println("::1: " + s);
//        System.out.println("2: " + s.toString());
//        System.out.println("3: " + MyUtilities.mimicObjectToString(s));
//        fields
        String fields = "1,2";
        //List<String> fieldList =  Arrays.asList(fields != null ? fields.split(",") : null);
        //Arrays.asList(test.split(","));
        System.out.println("=======>>"+fields.trim().isEmpty());
        Set<String> s = new HashSet(Arrays.asList(fields != null ? fields.split(",") : null));
        
        System.out.println("=========>1"+s+"::"+s.size());
        
        s.addAll(Arrays.asList("p,v,m>30,pradeep".split(",")));
        System.out.println("=========>>>>:"+s.toString()+"::");
        String str = s.toString();
        str  = str.substring(1,str.length()-1);
        System.out.println("=========>>>>:"+str+"::");
        String s11 = "vishal";
	    String s2 = new String("vishal");
	    String s33 = "vishal";
	    
	    System.out.println("s11: " + MyUtilities.mimicObjectToString(s11));
	    System.out.println("s2: " + MyUtilities.mimicObjectToString(s2));
	    System.out.println("s33: " + MyUtilities.mimicObjectToString(s33));
	    
	    if(s11.equals(s33))
	    	System.out.println("s1 equal s3");
	    if(s11.equals(s2))
	    	System.out.println("s1 equal s2");
	    if(s11 == s33)
	    	System.out.println("s1 = s3");
	    if(s11 == s2)
	    	System.out.println("s1 = s2");
	    s33 = "vishalM";
	    System.out.println("s33 again: " + MyUtilities.mimicObjectToString(s33));
	    if(s11.equals(s33))
	    	System.out.println("s1 equal s3");
	    if(s11.equals(s2))
	    	System.out.println("s1 equal s2");
	    if(s11 == s33)
	    	System.out.println("s1 = s3");
	    if(s11 == s2)
	    	System.out.println("s1 = s2");
    }
    
}




//public class Main {
//	  public static void main(String[] args) {
//	    HashMap<String, String> hMap = new HashMap<String, String>();
//
//	    hMap.put("1", "One");
//	    hMap.put("2", "Two");
//	    hMap.put("3", "Three");
//	    String s1 = "vishal";
//	    System.out.println(s1.hashCode()+":");
//	    s1 = "rakesh";
//	    String s3 = "vishal";
//	    System.out.println(s1.hashCode()+":"+s3.hashCode());
//	    System.out.println(hMap.containsValue("Two"));
//	    System.out.println(hMap.get("1"));
//	    String s11 = "vishal";
//	    String s2 = new String("vishal");
//	    String s33 = "vishal";
//	    if(s11.equals(s33))
//	    	System.out.println("s1 equal s3");
//	    if(s11.equals(s2))
//	    	System.out.println("s1 equal s2");
//	    if(s11 == s33)
//	    	System.out.println("s1 = s3");
//	    if(s11 == s2)
//	    	System.out.println("s1 = s2");
//	    s33 = "vishalM";
//		System.out.println("--------------"+new Object().toString());
//	    if(s11.equals(s33))
//	    	System.out.println("s1 equal s3");
//	    if(s11.equals(s2))
//	    	System.out.println("s1 equal s2");
//	    if(s11 == s33)
//	    	System.out.println("s1 = s3");
//	    if(s11 == s2)
//	    	System.out.println("s1 = s2");
//	    
//	    
//	  }
//	}