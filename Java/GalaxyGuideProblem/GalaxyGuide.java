import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class GalaxyGuide {

	public static void main(String[] args) {
		if (args.length > 0) {
			if (!args[0].endsWith(".txt")) {
				System.out.println(Constants.WRONG_FILE_FORMATE);
			} else {
				IOServices io = new IOServices();
				ProcessMessage processMessage = new ProcessMessage();
				List<String> inputMessages = io.readFile(args[0]);
				for (String message : inputMessages) {
					processMessage.interpretMessage(message);
				}
			}
		} else {
			System.out.println(Constants.FILE_INPUT_MISSING);
		}
	}

}

/*
 * To read input .txt file
 * */
class IOServices {
	public List<String> readFile(String fullPath) {
		File file = new File(fullPath);
		BufferedReader br;
		FileReader fr;
		List<String> lines = new ArrayList<String>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			try {
				String x;
				while ((x = br.readLine()) != null) {
					x = x.trim();
					// ignore blank line
					if (x.length() > 0) {
						lines.add(x);
					}
				}
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return lines;

	}
}

/*
 * ProcessMessage interpret input file line message(whether its assignment/question), process questions and print answer.
 * It's internally use RomanNumerals class to Roman to Decimal conversion.
 * */
class ProcessMessage {
	Map<String, Character> units = new HashMap<String, Character>();
	Map<String, Double> metals = new HashMap<String, Double>();

	public void interpretMessage(String message) {
		String[] words = message.split(Constants.DELIMETER);
		int msgLength = words.length;
		if (words[msgLength - 1].equals(Constants.QUESTION_MARK)) {
			processQuestion(words);
		} else if (msgLength == 3) {
			addUnit(words);
		} else if (words[msgLength - 1].equals(Constants.DEAL_UNIT)
				&& words[msgLength - 3].equals(Constants.EQUALITY_KEYWORD)) {
			addMetal(words);
		}
	}

	private void processQuestion(String[] words) {
		if (words[0].equals(Constants.QUESTION_DEFECTOR_HOW)) {
			if (words[1].equals(Constants.QUESTION_DEFECTOR_MUCH)) {
				if (words[2].equals(Constants.EQUALITY_KEYWORD)) {
					answerTheQuestions(Arrays.copyOfRange(words, 3, words.length - 1), false);
				} else {
					System.out.println(Constants.ERROR);
				}
			} else if (words[1].equals(Constants.QUESTION_DEFECTOR_MANY)) {
				if (words[2].equals(Constants.DEAL_UNIT)) {
					if (words[3].equals(Constants.EQUALITY_KEYWORD)) {
						answerTheQuestions(Arrays.copyOfRange(words, 4, words.length - 1), true);
					} else {
						System.out.println(Constants.ERROR);
					}
				} else {
					System.out.println(Constants.ERROR);
				}
			}
		} else {
			System.out.println(Constants.ERROR);
		}
	}

	private void addUnit(String[] words) {
		if (words[1].equals(Constants.EQUALITY_KEYWORD)) {
			if (words[2].length() == 1) {
				char inputCharacter = words[2].charAt(0);
				if (RomanNumeral.ROMAN_LETTERS.containsKey(inputCharacter)) {
					units.put(words[0], inputCharacter);
				}
			}
		} // No else, in case something is wrong in assignment statement, just ignore it, don't show error as it's not an question
	}

	private void addMetal(String[] words) {
		try {
			int length = words.length;
			double metalValue = Double.parseDouble(words[length - 2]);
			long noOfMetalElement = getDecimalNumber(Arrays.copyOfRange(words, 0, length - 4));
			if (noOfMetalElement > 0) {
				double unitPerMetalElemnt = metalValue / noOfMetalElement;
				metals.put(words[length - 4], unitPerMetalElemnt);
			}
		} catch (NumberFormatException e) {
			// dont add metal as value if not a Number.
		}
	}

	private Character[] convertWordsInRomanLetter(String[] words) {
		Character[] result = new Character[words.length];
		int i = 0;
		for (String word : words) {
			if (units.containsKey(word)) {
				result[i] = units.get(word);
				i++;
			} else {
				return null;
			}
		}
		return result;
	}

	private void answerTheQuestions(String[] words, boolean isMetalQuestion){
		if(isMetalQuestion){
			long noOfMetalElement = getDecimalNumber(Arrays.copyOfRange(words, 0, words.length - 1));
			String metal = words[words.length - 1];
			if(noOfMetalElement > 0){
				if(metals.get(metal) != null){
					double value = noOfMetalElement * metals.get(metal);
					printAnswer(words, value);
				} else{
					System.out.println(Constants.ERROR);
				}
			} else{
				System.out.println(Constants.ERROR);
			}
		}else{
			long totalUnits = getDecimalNumber(Arrays.copyOfRange(words, 0, words.length));
			if(totalUnits > 0){
				printAnswer(words, (double)totalUnits);
			} else{
				System.out.println(Constants.ERROR);
			}
			
		}
	}
	private void printAnswer(String[] words, double value){
		StringBuilder answer = new StringBuilder();
		for (String word : words) {
			answer.append(word).append(Constants.DELIMETER);
		}
		answer.append(Constants.EQUALITY_KEYWORD).append(Constants.DELIMETER).append(value).append(Constants.DELIMETER).append(Constants.DEAL_UNIT);
		System.out.println(answer);
	}
	private long getDecimalNumber(String[] words){
		Character[] romanLetters = convertWordsInRomanLetter(words);
		if(romanLetters != null){
			return RomanNumeral.getDecimalNumber(romanLetters);
		}else{
			return 0;
		}
	}
}

/*
 * For all Roman to Decimal operation
 * */
class RomanNumeral {
	public static final Map<Character, Integer> ROMAN_LETTERS;

	static {
		Map<Character, Integer> tmp = new HashMap<Character, Integer>();
		tmp.put('I', 1);
		tmp.put('V', 5);
		tmp.put('X', 10);
		tmp.put('L', 50);
		tmp.put('C', 100);
		tmp.put('D', 500);
		tmp.put('M', 1000);
		ROMAN_LETTERS = Collections.unmodifiableMap(tmp);
	}

	public static long getDecimalNumber(Character[] romanLetters) {
		long number = 0;
		if (romanLetters.length == 0) {
			return 1;
		} else if (romanLetters.length == 1) {
			return ROMAN_LETTERS.get(romanLetters[0]);
		}

		StringBuilder romanNumber = new StringBuilder();
		for (Character character : romanLetters) {
			romanNumber.append(character);
		}
		boolean isValid = validateInput(romanNumber.toString());
		char currentChar;
		int currentCharValue, nextCharValue;
		if (isValid) {
			for (int i = 0; i < romanLetters.length; i++) {
				currentChar = romanLetters[i];
				nextCharValue = (i == romanLetters.length - 1) ? 0 : ROMAN_LETTERS.get(romanLetters[i + 1]);
				currentCharValue = ROMAN_LETTERS.get(currentChar);
				if (nextCharValue != 0) {
					if (currentCharValue < nextCharValue) {
						number += nextCharValue - currentCharValue;
						i++;
					} else {
						number += currentCharValue;
					}
				} else {
					number += ROMAN_LETTERS.get(romanLetters[i]);
				}
			}
		} else {
			return 0;
		}
		return number;
	}

	private static boolean validateInput(String romanNumber) {
		String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		return Pattern.matches(regex, romanNumber);
	}

}
/*
 * All constants
 * Ideally it should be .properties file so we don't need to JAVA Code.
 * */
class Constants {
	public static final String DELIMETER = " ";
	public static final String FILE_INPUT_MISSING = "Please provide input file path as a commanline argument.";
	public static final String WRONG_FILE_FORMATE = "Please provide .txt format input file.";
	public static final String QUESTION_MARK = "?";
	public static final String EQUALITY_KEYWORD = "is";
	public static final String DEAL_UNIT = "Credits";
	public static final String QUESTION_DEFECTOR_HOW = "how";
	public static final String QUESTION_DEFECTOR_MUCH = "much";
	public static final String QUESTION_DEFECTOR_MANY = "many";
	public static final String ERROR = "I have no idea what you are talking about";
}