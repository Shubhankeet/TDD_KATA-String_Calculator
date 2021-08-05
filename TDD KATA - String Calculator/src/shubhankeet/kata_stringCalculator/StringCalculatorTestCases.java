package shubhankeet.kata_stringCalculator;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class StringCalculatorTestCases {
	
	@Test
	public void sumOfEmptyStringWillReturn0() {
		assertThat(StringCalculator.Add(""), is(0));
	}

}
