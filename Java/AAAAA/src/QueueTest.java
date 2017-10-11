import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	static Queue<String> q;
	public static void main(String[] args) {

	}
	public static Queue<String> create(String [] arr){
		q = new LinkedList<String>();
		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
		}
		return q;
	}
	
	public static void print(){
		q.forEach(e -> System.out.println(e));
	}
}
