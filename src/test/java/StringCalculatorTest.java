import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addShouldReturn0WhenEmptyInput() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addShouldReturn1WhenInputIs1() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void addShouldReturnSumWhen2PositiveNumbersEntered() {
        assertEquals(5, calculator.add("2,3"));
    }

    @Test
    public void addShouldReturnSumWhenAPositiveAndNegativeNumberEntered() {
        assertEquals(11, calculator.add("9,2"));
    }

    @Test
    public void addShouldReturnNegativeNumberWhenNegativeNumberEntered() {
        assertEquals(13, calculator.add("13"));
    }

    @Test
    public void addShouldReturnSumFor3PositiveNumbers() {
        assertEquals(12, calculator.add("9,1,2"));
    }

    @Test
    public void addShouldReturnSumForNewLineDelimiter() {
        assertEquals(13, calculator.add("1\n3,5\n4"));
    }

    @Test
    public void addShouldReturnForCustomDelimiter() {
        assertEquals(6, calculator.add("//;\n2;4"));
    }

    @Test
    public void addShouldReturnSumForCustomDelimiterAndInitialInputs() {
        assertEquals(12, calculator.add("//*\n3*5,2\n2"));
    }

    @Test
    public void addShouldReturnExceptionIfNegativeNumberEntered() {
        expectedException.expect(InvalidParameterException.class);
        expectedException.expectMessage("Negatives Not allowed -> -1");
        calculator.add("3,-1");
    }
}
