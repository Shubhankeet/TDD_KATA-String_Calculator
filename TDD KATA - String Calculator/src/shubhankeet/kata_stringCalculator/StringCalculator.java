package shubhankeet.kata_stringCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	public static int Add(String numbers) {
		if (numbers.isEmpty())
			return 0;
		else {
			Stream<String> numberArray = Arrays.stream(numbers.split(",|\n"));
			return numberArray.mapToInt(Integer::parseInt).sum();
		}
			
	}

}
