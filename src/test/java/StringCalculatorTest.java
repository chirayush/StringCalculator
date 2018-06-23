import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

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
        assertEquals(7, calculator.add("9,-2"));
    }

    @Test
    public void addShouldReturnNegativeNumberWhenNegativeNumberEntered() {
        assertEquals(-3, calculator.add("-3"));
    }

    @Test
    public void addShouldReturnSumFor3PositiveNumbers() {
        assertEquals(12, calculator.add("9,1,2"));
    }

    @Test
    public void addShouldReturnSumForNewLineSplitter() {
        assertEquals(13, calculator.add("1\n3,5\n4"));
    }

    @Test
    public void addShouldReturn0IfInputNotValid() {
        assertEquals(0, calculator.add("7,\n5"));
    }
}
