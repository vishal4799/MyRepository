
public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private int age;

	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Employee e) {
		if(this.name.compareTo(e.name) < 0){
			return -1;
		}else{
			return 1;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name +" : " + this.age +" : " + this.id;
	}
}
