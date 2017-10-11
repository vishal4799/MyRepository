import java.util.Collection;
import java.util.AbstractCollection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.List;
import java.util.AbstractList;
import java.util.Queue;
import java.util.AbstractQueue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class CollectionsTest {

	String[] arr = {"00","30","10","20"};
	
	public static void main(String[] args) {
		CollectionsTest ct = new CollectionsTest();
		//ct.arrayListTest();
		//ct.hashSetTest();
		ct.hashMapTest();
		//ct.queueTest();
		//ct.dequeTest();
		//ct.stackTest();
		//ct.linkedHashMapTest();
		//ct.treeMapTest();
		ct.treeSetTest();
	}
	private void arrayListTest() {
		System.out.println("=======list======");
		List<String> list = ListTest.create(arr);
		Collections.sort(list);
		ListTest.print();
		System.out.println(Collections.binarySearch(list, "hello3"));
		System.out.println("max:"+Collections.max(list, null));
		System.out.println("min:"+Collections.min(list, null));
		list.stream()
		.filter(e -> e.charAt(0) == 'h')
		.forEach(e -> System.out.println(e));
		String s = arr[0];
		System.out.println(s.split("e")[0]);
	}
	private void hashSetTest() {
		System.out.println("========set=======");
		Set<String> set = SetTest.create(arr);
		set
		.stream()
		.filter(e -> e.charAt(0) == 'h')
		.forEach(e -> System.out.println(e));
	}
	private void hashMapTest() {
		Function<String, String> a = s -> s+"yes";
		System.out.println("========map=======");
		Map<String, String> map = MapTest.create(arr);
		map.put("1", "15");
		final Object  obj = "vishal";
		String s1 = a.apply("Abhay");
		map
		//.stream() //stream not allowed as map is not collection
		//.filter(e -> e.charAt(0) == 'h') //filter not allowed as map is not collection
		.forEach((k,v)->{});
	}
	
	public String a(String k , String v){
			//obj = "need to be final";
		    arr[1] = "2";
			System.out.println(k+"::"+v);
			System.out.println(k+"::"+arr[1]);
			return null;
		
	}
	private void queueTest() {
		System.out.println("========Queue=======");
		Queue<String> queue = QueueTest.create(arr);
		queue
		.stream()
		.filter(e -> e.charAt(0) == 'h')
		.forEach(k -> {
			System.out.println(k);
		});
		System.out.println("offer:"+queue.offer("vishal"));
		System.out.println("add:"+queue.add("vishalAdd"));
		System.out.println("peek:"+queue.peek());
		System.out.println("poll:"+queue.poll());
		System.out.println("remove:"+queue.remove());
		System.out.println("===AFTER=====:");QueueTest.print();
	}
	private void dequeTest() {
		System.out.println("========Deque=======");
		Deque<String> deque = DequeTest.create(arr);
		System.out.println("===BEFORE===:");DequeTest.print();
		System.out.println("===FILTER===:");
		deque
		.stream()
		.filter(e -> e.charAt(0) == 'h')
		.forEach(k -> {
			System.out.println(k);
		});
		System.out.println();
		System.out.println("*offer:"+deque.offer("31"));
		System.out.println("*add:"+deque.add("32"));
		System.out.println("*offer:"+deque.offerFirst("1"));
		deque.addFirst("2");
		System.out.println("*peek:"+deque.peek());
		System.out.println("*element:"+deque.element());
		System.out.println("===1===:");DequeTest.print();
		System.out.println("*poll:"+deque.poll());
		System.out.println("*remove:"+deque.remove());
		System.out.println("===2===:");DequeTest.print();
		System.out.println("*poll:"+deque.pollLast());
		System.out.println("*remove:"+deque.removeLast());
		System.out.println("===AFTER===:");DequeTest.print();
		
		
	}
	private void stackTest() {
		Stack<String> s = new Stack<String>();//Stack is a class and extends vector.
		s.add("1");
		s.push("2");
		System.out.println("peek:"+s.peek());
		System.out.println(s.toString());
		s.pop();
		System.out.println(s.toString());
		System.out.println("search-result for 2:"+s.search("2"));
		System.out.println("search-result for 1:"+s.search("1"));
	}
	private void linkedHashMapTest() {
		System.out.println("========linkedHashMap=======");
		Map<String, String> lhmap = MapTest.createLinkedHashmap(arr);
		System.out.println(lhmap.toString());
	}
	private void treeMapTest() {
		/*
		 * TreeMap can only sort by the key. 
		 * A TreeMap is always sorted by the keys, anything else is impossible. 
		 * A Comparator merely allows you to control how the keys are sorted. 
		 * If you want the sorted values, you have to extract them into a List and sort that.
		*/
		System.out.println("========treeMap=======");
		SortedMap<String, String> lhmap = MapTest.createTreeMap(arr);
		System.out.println(lhmap.toString());
		lhmap.clear();
		lhmap.put("bbb", "444");
		lhmap.put("aaa", "555");
		lhmap.put("ddd", "222");
		lhmap.put("ccc", "333");
		System.out.println(lhmap.firstKey()); //only available in SortedMap
		System.out.println(lhmap.lastKey()); //only available in SortedMap
		System.out.println(lhmap.values().toString());
		System.out.println(lhmap.toString());
	}
	private void treeSetTest() {
		System.out.println("========treeMap=======");
		SortedSet<String> tSet = SetTest.createTreeSet(arr);
		System.out.println(tSet.toString());
		tSet.clear();
		tSet.add("bbb");
		tSet.add("aaa");
		tSet.add("ddd");
		tSet.add("ccc");
		System.out.println(tSet.first());
		System.out.println(tSet.last());
		System.out.println(tSet.toString());
	}
}
