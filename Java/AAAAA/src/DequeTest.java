import java.util.Deque;
import java.util.ArrayDeque;;

public class DequeTest {
	static Deque<String> q;
	public static void main(String[] args) {

	}
	public static Deque<String> create(String [] arr){
		q = new ArrayDeque<String>();
		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
		}
		return q;
	}
	
	public static void print(){
		q.forEach(e -> System.out.println(e));
	}
}
