package shubhankeet.kata_stringCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	private String delimiter;
	private String numberString;
	
	private StringCalculator(String delimiter, String numberString) {
		this.delimiter = delimiter;
		this.numberString = numberString;
	}
	
	public static int Add(String numbers) {
		if (numbers.isEmpty())
			return 0;
		
		StringCalculator calculateInput = parseTheInputString(numbers);
		
			Stream<String> numberArray = Arrays.stream(calculateInput.numberString.split(calculateInput.delimiter));
			return numberArray.mapToInt(Integer::parseInt).sum();
		}

	private static StringCalculator parseTheInputString(String numbers) {
		if (numbers.startsWith("//")) {
			String []items = numbers.split("\n", 2);
			return new StringCalculator(items[0].substring(2), items[1]);
		} else {
			return new StringCalculator(",|\n", numbers);
		}
	}		
}
