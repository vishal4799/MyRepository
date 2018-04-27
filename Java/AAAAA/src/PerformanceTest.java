import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PerformanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		//Any time consuming code you want to test
		for (int i = 0; i < 1000000; i++) {
			System.out.println("hello"+i);
		}
		long end = System.currentTimeMillis();

		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
	}

}
