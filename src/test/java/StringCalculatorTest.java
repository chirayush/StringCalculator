import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

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
    public void addShouldReturn11With4And7() {
        assertEquals(85, stringCalculator.add("14,71"));
    }

    @Test
    public void addShouldReturn13When3And5And5() {
        assertEquals(13, stringCalculator.add("3,5,5"));
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
    public void addShouldReturnSumWithCustomDelimiterOfStar() {
        assertEquals(7, stringCalculator.add("//&\n2&5"));
    }

//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();
//
//    @Test
//    public void addShouldThrowExceptionIfNegativeNumber() {
//        expectedException.expect(IllegalArgumentException.class);
//        expectedException.expectMessage("negatives not allowed -3");
//        stringCalculator.add("-3,5");
//    }

}
