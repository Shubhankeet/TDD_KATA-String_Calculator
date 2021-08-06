package shubhankeet.kata_stringCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	public static int Add(String numbers) {
		if (numbers.isEmpty())
			return 0;
		
		String delimiterString = ",|\n";
		if (numbers.startsWith("//")) {
			String []items = numbers.split("\n", 2);
			delimiterString = items[0].substring(2);
			numbers = items[1];
		}
			Stream<String> numberArray = Arrays.stream(numbers.split(delimiterString));
			return numberArray.mapToInt(Integer::parseInt).sum();
		}
			
	}
