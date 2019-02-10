import java.io.IOException;

public class HCL {

	private int x = 0;
	protected int x1 = 0;
	private static int y = 0;
	protected static int y1 = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int x = 1;
		int x1 = 2;
		int y = 3;
		int y1 = 4;
		double d = 10.0 / 0;
		if(d == Double.POSITIVE_INFINITY) {
			System.out.println("TURE");
		}
		System.out.println(a());
		new HCL().new inner().go();
	}
	class inner{
		void go() {
			System.out.println(x +":"+ x1+":"+ y+":"+y1);
		}
	}

	public static int a() //throws Exception
	{
		try {
			throw new IOException("..");
		}catch (RuntimeException e) {
			System.out.println("RE");
		}
		finally {
			return -1;
		}
	}
}
	