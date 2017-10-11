import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class TestGalaxyGuide {
	
	@Test
	public void tesIOServices(){
		IOServices io = new IOServices();
		List<String> lines = io.readFile("C:\\Users\\vmakwana\\Documents\\MyDocuments\\TestJavaProjects\\input.txt");
		assertNotNull(lines);
		assertEquals("No of lines not match", 21, lines.size());
		lines = io.readFile("C:\\Users\\vmakwana\\Documents\\MyDocuments\\TestJavaProjects\\filenotfound.txt");
		assertEquals("No of lines not match", 0, lines.size());
	}
	
	@Test
	public void testProcessMessage(){
		ProcessMessage processMessage = new ProcessMessage();
		processMessage.interpretMessage("glob is A");
		assertEquals("Units Map shouldn't have glob entry as A is not roman letter", false, processMessage.units.containsKey("glob"));
		processMessage.interpretMessage("glob is I");
		assertEquals("Units Map should have proper value for glob", (Character)'I', processMessage.units.get("glob"));
		processMessage.interpretMessage("prok is V");
		processMessage.interpretMessage("pish is X");
		processMessage.interpretMessage("glob prok Silver is 68 Credits");
		assertEquals("Metal Map should have Silver entry with proper value.", (Double)17.0, processMessage.metals.get("Silver"));
		processMessage.interpretMessage("glob tegj Gold is 68 Credits");
		//tegj not defined yet. 
		assertNull(processMessage.metals.get("Gold"));
		processMessage.interpretMessage("tegj is C");
		processMessage.interpretMessage("pish tegj Gold is 900 Credits");
		assertEquals("Metal Map should have Gold entry with proper value.", (Double)10.0, processMessage.metals.get("Gold"));
		processMessage.interpretMessage("Hello World ?");
		processMessage.interpretMessage("how many Credits is glob prok Silver ?");
		processMessage.interpretMessage("how many Credits is pish tegj Gold ?");
		processMessage.interpretMessage("how many Credits is glob prok Iron ?");//iron not added yet
		processMessage.interpretMessage("how many Credits is glob tegj Silver ?");//glob:I,tegj:C  IC is invalid.
		//check the console.
	}
	
	@Test
	public void testRomanNumeral(){
		Character[] charArray = {'I','I','I','I'};
		long decimalNumber = RomanNumeral.getDecimalNumber(charArray);
		assertEquals("decimalNumber should be zero as IIII is invalid roman number", 0 ,decimalNumber);
		decimalNumber = RomanNumeral.getDecimalNumber(new Character[]{'I','I','I'});
		assertEquals("decimalNumber should have proper decimal value", 3 ,decimalNumber);
		decimalNumber = RomanNumeral.getDecimalNumber(new Character[]{'I','V'});
		assertEquals("decimalNumber should have proper decimal value", 4 ,decimalNumber);
		decimalNumber = RomanNumeral.getDecimalNumber(new Character[]{'I','V','V'});
		assertEquals("Invalid Roman Number", 0 ,decimalNumber);
		decimalNumber = RomanNumeral.getDecimalNumber(new Character[]{'M','C','M','I','I'});
		assertEquals("decimalNumber should have proper decimal value", 1902 ,decimalNumber);
		decimalNumber = RomanNumeral.getDecimalNumber(new Character[]{'M','M','M','C','M','X','C','I','X'});
		assertEquals("decimalNumber should have proper decimal value", 3999 ,decimalNumber);
	}
}

