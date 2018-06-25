import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ErrorHandler {

    private final Stream<String> inputs;

    ErrorHandler(Stream<String> inputs) {
        this.inputs = inputs;
    }

    boolean isValidInput() throws NumberFormatException {

        List<Integer> negativeNumbersList = getNegativeNumbers();

        if (negativeNumbersList.size() > 0) {
            StringBuilder negativeNumbersString = buildNegativeNumberString(negativeNumbersList);
            throw new IllegalArgumentException("Negatives Not allowed ->" + negativeNumbersString);
        }
        return true;
    }

    private StringBuilder buildNegativeNumberString(List<Integer> negativeNumbersList) {
        StringBuilder negativeNumbersString = new StringBuilder();
        negativeNumbersList.forEach(negativeNumber ->
                negativeNumbersString
                        .append(" ")
                        .append(negativeNumber));
        return negativeNumbersString;
    }

    private List<Integer> getNegativeNumbers() {
        List<Integer> negativeNumbersList = new ArrayList<>();
        inputs.mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .forEach(negativeNumbersList::add);
        return negativeNumbersList;
    }
}
