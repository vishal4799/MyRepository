import java.io.File;
import java.util.List;

public class FetchWindowsDirectory {

	public static void main(String[] args) {
		File root = new File("c://");
		String list[] = root.list();
		for (String string : list) {
			System.out.println(string);
		}
		
	}

}
