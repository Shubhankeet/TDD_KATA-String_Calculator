package shubhankeet.kata_stringCalculator;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class StringCalculatorTestCases {
	
	@Test
	public void sumOfEmptyStringReturns0() {
		assertThat(StringCalculator.Add(""), is(0));
	}
	
	@Test
	public void sumOfSingleNumberString() {
		assertThat(StringCalculator.Add("1"), is(1));
		assertThat(StringCalculator.Add("54"), is(54));
		assertThat(StringCalculator.Add("176"), is(176));
	}
	
	@Test
	public void sumOfCommaSeparatedTwoNumberStrings() {
		assertThat(StringCalculator.Add("1,2"), is(3));
		assertThat(StringCalculator.Add("57,60"), is(117));
		assertThat(StringCalculator.Add("34,200"), is(234));
	}

}
