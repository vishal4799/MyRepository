
public class GenericTest {

	public static void main(String[] args) {
		Box b1 = new Box();
		b1.set(1);
		int ix1 = (int)b1.get();
		//String s1 = (String)b1.get(); // run time error for type casting without generic
		
		
		Boxx<String, Integer> bx1 = new Boxx<String, Integer>();
		bx1.set("1");
		bx1.setK(2);
		String sx1 = bx1.get(); // run time error for type casting without generic
		//int ix1 = (int)bx1.get(); // this statment not allowed at all at compile time
		//String sx1 = bx1.getK(); // this statment not allowed at all at compile time
	}

}

class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}

/**
 * Generic version of the Box class.
 * @param <T> (u can user any letter instead of T) the type of the value being boxed
 */
class Boxx<V, K> {
    // T stands for "Type"
    private V t;
    private K k;
    public void set(V t) { this.t = t; }
    public V get() { return t; }
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
}
