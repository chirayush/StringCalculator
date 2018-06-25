import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

class StringCalculator {

    int add(String allInputs) {

        InputCreator inputCreator = new InputCreator(allInputs);

        Supplier<Stream<String>> supplierInputStream = inputCreator::splitIntoInputs;

        try {
            if (!isValidInput(supplierInputStream.get())) return 0;
        } catch (NumberFormatException ex) {
            return 0;
        }

        return supplierInputStream.get()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isValidInput(Stream<String> inputs) throws NumberFormatException {

        List<Integer> negativeNumbersList = getNegativeNumbers(inputs);

        if (negativeNumbersList.size() > 0) {
            StringBuilder negativeNumbersString = buildNegativeNumberString(negativeNumbersList);
            throw new InvalidParameterException("Negatives Not allowed ->" + negativeNumbersString);
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

    private List<Integer> getNegativeNumbers(Stream<String> inputs) {
        List<Integer> negativeNumbersList = new ArrayList<>();
        inputs.mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .forEach(negativeNumbersList::add);
        return negativeNumbersList;
    }
}
