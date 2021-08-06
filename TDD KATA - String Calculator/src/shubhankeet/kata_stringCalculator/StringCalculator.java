package shubhankeet.kata_stringCalculator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {

	private String delimiter;
	private String numberString;

	private StringCalculator(String delimiter, String numberString) {
		this.delimiter = delimiter;
		this.numberString = numberString;
	}

	private int sumOfStrings() {
		if (getNumberString().anyMatch(num -> num < 0)) {
			throw new IllegalArgumentException();
		}
		return getNumberString().sum();
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
