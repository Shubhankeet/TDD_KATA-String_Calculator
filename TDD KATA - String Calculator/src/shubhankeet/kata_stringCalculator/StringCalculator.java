package shubhankeet.kata_stringCalculator;

import java.util.stream.IntStream;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

	private String delimiter;
	private String numberString;

	private StringCalculator(String delimiter, String numberString) {
		this.delimiter = delimiter;
		this.numberString = numberString;
	}

	private int sumOfStrings() {
		checkNoNegativeNumbersPresent();
		return getNumberString().sum();
	}

	private void checkNoNegativeNumbersPresent() {
		String multipleNegativeNumbers = getNumberString().filter(num -> num < 0).mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if (!multipleNegativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: " + multipleNegativeNumbers);
		}
	}

	private IntStream getNumberString() {
		if (numberString.isEmpty()) {
			return IntStream.empty();
		} else {
			return Stream.of(numberString.split(delimiter)).mapToInt(Integer::parseInt);
		}
	}

	public static int Add(String numbers) {
		return parseTheInputString(numbers).sumOfStrings();
	}

	public static int SumGreaterThan1000(String numbers) {
		String[] strArray = numbers.split(","); 
		int sum = 0;

		for (String number : strArray) {
			if (Integer.parseInt(number) < 1000)
				sum += Integer.parseInt(number);
		}
		return sum;
	}

	private static StringCalculator parseTheInputString(String numbers) {
		if (numbers.startsWith("//")) {
			String[] items = numbers.split("\n", 2);
			return new StringCalculator(parsingTheDelimiter(items[0]), items[1]);
		} else {
			return new StringCalculator(",|\n", numbers);
		}
	}
	
	private static String parsingTheDelimiter(String item) {
		return Pattern.quote(item.substring(2));
	}
}
