package shubhankeet.kata_stringCalculator;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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
	
	@Test
	public void sumOfCommaSeparatedGreaterThanTwoNumberStrings() {
		assertThat(StringCalculator.Add("1,2,3"), is(6));
		assertThat(StringCalculator.Add("57,60,10,45"), is(172));
		assertThat(StringCalculator.Add("34,200,5,5"), is(244));
	}
	
	@Test
	public void sumOfNumberStringsWithNewLineinBetween() {
		assertThat(StringCalculator.Add("1\n5"), is(6));
		assertThat(StringCalculator.Add("20\n30\n9"), is(59));
	}
	
	@Test
	public void sumOfNumberStringsWithNewLineOrCommainBetween() {
		assertThat(StringCalculator.Add("1\n2,3"), is(6));
		assertThat(StringCalculator.Add("43\n21,30"), is(94));
	}
	
	@Test
	public void sumOfNumberStringsWithmultipleDelimiters() {
		assertThat(StringCalculator.Add("//;\n1;2"), is(3));
		assertThat(StringCalculator.Add("//;\n4;5"), is(9));
	}
	
	@Rule
	public ExpectedException expectedExceptionBehaviour = ExpectedException.none();
	
	@Test
	public void throwsExceptionMessageOnNegativeNumber() {
		expectedExceptionBehaviour.expect(IllegalArgumentException.class);
		expectedExceptionBehaviour.expectMessage("negatives not allowed: -9");
		
		StringCalculator.Add("-9");
	}
	
	@Test
	public void throwsExceptionMessageAlongWithMultipleNegativeNumbers() {
		expectedExceptionBehaviour.expect(IllegalArgumentException.class);
		expectedExceptionBehaviour.expectMessage("negatives not allowed: -17,-89,-101");
		
		StringCalculator.Add("-17,-89,-101");
	}
	
	@Test
	public void ignoreNumberBiggerThan1000() {
		assertThat(StringCalculator.SumGreaterThan1000("2,1001"), is(2));
		assertThat(StringCalculator.SumGreaterThan1000("5,2001,1567,25"), is(30));
	}

}
