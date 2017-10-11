import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestSorting {

	public TestSorting() {
		// TODO Auto-generated constructor stub
		Tests t = new Tests();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSorting ts = new TestSorting();
		ts.sortArrList();
	}
	
	public void sortArrList() {
		List<Employee> l= new ArrayList<Employee>();
		l.add(new Employee(1, "vishal", 23));
		l.add(new Employee(2, "rakesh", 25));
		l.add(new Employee(3, "manish", 20));
		Collections.sort(l);
		System.out.println(l.toString());
	}

}
