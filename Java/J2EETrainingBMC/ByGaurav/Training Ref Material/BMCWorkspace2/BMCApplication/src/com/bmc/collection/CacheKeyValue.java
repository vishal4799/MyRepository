package com.bmc.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CacheKeyValue<K,V> {
	
	Map<K,V> map=new HashMap<K,V>();
	
	public void put(K key, V value){
		//perform operations on key and value and then store
		//in map
		map.put(key,value);
		
	}
	public List<K> getKeys(){
		
		List<K> keysList=new ArrayList<K>();
		Set<K> keys=map.keySet();
		
		Iterator<K> iterator=keys.iterator();
		K key=null;
		while(iterator.hasNext()){
			key=iterator.next();
			keysList.add(key);
		}
		return keysList;
	}
	

}
