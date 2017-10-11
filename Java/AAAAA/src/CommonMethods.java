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

public class CommonMethods {
	public List<String> getDirectFriendsForUser(String user){
    	return null;
    }
    public List<String> getAttendedCoursesForUser(String user){
    	return null;
    }

    public List<String> getRankedCourses(String user) {
    	List<String> allUsers = getUsersInSocialCircle(user);
    	HashMap<String, Integer> hm = new HashMap<>();
    	List<String> courses;
    	for (String usr : allUsers) {
    		courses= getAttendedCoursesForUser(usr);
    		for (String course : courses) {
				if(hm.get(course) != null){
					hm.put(course , hm.get(course)+1);
				}else{
					hm.put(course , hm.get(course));
				}
			}
    	}
    	
    	hm = sortByValues(hm);
    	courses = new ArrayList<String>();
    	Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
             Map.Entry me = (Map.Entry)iterator.next();
             courses.add((String)me.getKey());
        }
        return courses;
        
    }

    public List<String> getUsersInSocialCircle(String user){
    	Main m = new Main();
        List<String> userList = new ArrayList();
        userList = getDirectFriendsForUser(user);
        List<String> userListCopy = new ArrayList<String>(userList);
        for (String directFriend : userListCopy) {
        	userList.addAll(getDirectFriendsForUser(directFriend));
		}
        return userList;
    }
    private static HashMap sortByValues(HashMap map) { 
        List list = new LinkedList<>(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator(){
             public int compare(Object o1, Object o2) {
            	if(o1 !=null && o2 != null){
            		return ((Comparable) ((Map.Entry) (o1)).getValue())
                            .compareTo(((Map.Entry) (o2)).getValue());
            	}
                return 0;
             }
        });
        HashMap sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext();) {
               Map.Entry entry = (Map.Entry) it.next();
               sortedHashMap.put(entry.getKey(), entry.getValue());
        } 
        return sortedHashMap;
   }
}
