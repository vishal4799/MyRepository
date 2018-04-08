
public class RegEXTest {

	public static void main(String[] args) throws Exception
	    {
	    	String REGEX_SPECIAL_CHAR = "[a-zA-Z\\d\\s]*";
	    	System.out.println("RegEX::"+ "albha numerice 123 whitespace".matches(REGEX_SPECIAL_CHAR));
	    }

}
