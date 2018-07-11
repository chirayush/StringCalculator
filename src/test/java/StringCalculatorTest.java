import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void addShouldReturn0ForEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addShouldReturn3When3IsEntered() {
        assertEquals(3, stringCalculator.add("3"));
    }

    @Test
    public void addShouldReturn5When5IsEntered() {
        assertEquals(15, stringCalculator.add("15"));
    }

    @Test
    public void addShouldReturn8With3And5() {
        assertEquals(8, stringCalculator.add("3,5"));
    }

    @Test
    public void addShouldReturnSumWhenNewLineAndCommaDelimiter() {
        assertEquals(12, stringCalculator.add("3,3\n6"));
    }

    @Test
    public void addShouldReturnSumWithCustomDelimiterOfSemiColon() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void addShouldReturnSumWithCustomDelimiterOfAmpersand() {
        assertEquals(7, stringCalculator.add("//&\n2&5"));
    }

    @Test
    public void addShouldReturnSumWithCustomDelimiterOfDash() {
        assertEquals(7, stringCalculator.add("//-\n2-5"));
    }

    // ToDo : Get star working

//    @Test
//    public void addShouldThrowExceptionIfNegativeNumber() {
//        expectedException.expect(IllegalArgumentException.class);
//        expectedException.expectMessage("negatives not allowed -7");
//        stringCalculator.add("-7,5");
//    }
//
//    @Test
//    public void addShouldThrowExceptionAndPrintMultipleNegativeNumber() {
//        expectedException.expect(IllegalArgumentException.class);
//        expectedException.expectMessage("negatives not allowed -3 -5");
//        stringCalculator.add("-3,5\n-5");
//    }
//
    @Test
    public void addShouldIgnoreNumbersGreaterThan1000() {
        assertEquals(2, stringCalculator.add("2,1001"));
    }

    @Test
    public void addShouldNotIgnore1000() {
        assertEquals(1002, stringCalculator.add("2,1000"));
    }
}
