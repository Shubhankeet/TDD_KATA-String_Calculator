package shubhankeet.kata_stringCalculator;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

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
		if (getNumberString().anyMatch(num -> num < 0)) {
			String multipleNegativeNumbers = getNumberString().filter(num -> num < 0).mapToObj(Integer::toString).collect(Collectors.joining(","));
			throw new IllegalArgumentException("negatives not allowed: " + multipleNegativeNumbers);
		}
	}

	private IntStream getNumberString() {
		return Arrays.stream(numberString.split(delimiter)).mapToInt(Integer::parseInt);
	}

	public static int Add(String numbers) {
		if (numbers.isEmpty())
			return 0;

		return parseTheInputString(numbers).sumOfStrings();
	}

	private static StringCalculator parseTheInputString(String numbers) {
		if (numbers.startsWith("//")) {
			String[] items = numbers.split("\n", 2);
			return new StringCalculator(items[0].substring(2), items[1]);
		} else {
			return new StringCalculator(",|\n", numbers);
		}
	}
}
