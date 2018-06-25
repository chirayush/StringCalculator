import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class StringCalculator {

    int add(String allInputs) {
        Stream<String> inputsStream  = splitIntoInputs(allInputs);

        if (!isValidInput(inputsStream)) return 0;

        return sumOf(inputsStream);
    }

    private int sumOf(Stream<String> inputs) {
        return inputs.mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isValidInput(Stream<String> inputs) {

        List<Integer> negativeNumbersList = new ArrayList<>();
        try {

            inputs.mapToInt(Integer::parseInt)
                    .filter(num -> num < 0)
                    .forEach(negativeNumbersList::add);


        } catch (NumberFormatException ex) {
            return false;
        }

        if (negativeNumbersList.size() > 0) {
            StringBuilder negativeNumbersString = new StringBuilder();
            negativeNumbersList.forEach(negativeNumber -> {
                negativeNumbersString.append(" ").append(negativeNumber);
            });
            throw new InvalidParameterException("Negatives Not allowed ->" + negativeNumbersString);
        }
        return true;
    }

    private Stream<String> splitIntoInputs(String allInputs) {
        char delimiter = getCustomDelimiter(allInputs);
        if (delimiter != ' ') {
            String customDelimitedInputs = allInputs.substring(4)
                    .replace(String.valueOf(delimiter), ",");
            return splitIntoBasicInputs(customDelimitedInputs);
        }
        return splitIntoBasicInputs(allInputs);
    }

    private char getCustomDelimiter(String allInputs) {
        char delimiter = ' ';
        if (allInputs.startsWith("//")
                && "\n".equals(allInputs.substring(3, 4))) {
            delimiter = allInputs.charAt(2);
        }
        return delimiter;
    }

    private Stream<String> splitIntoBasicInputs(String allInputs) {
        return Arrays.stream(allInputs
                .replace("\n", ",")
                .split(","));
    }
}
