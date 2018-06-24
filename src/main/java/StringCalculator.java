import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class StringCalculator {

    int add(String allInputs) {
        String[] inputs = splitIntoInputs(allInputs).toArray(String[]::new);

        if (!isValidInput(inputs)) return 0;

        return sumOf(inputs);
    }

    private int sumOf(String[] inputs) {
        int sum = 0;
        for (String input : inputs) {
            sum += convertIntoInt(input);
        }
        return sum;
    }

    private int convertIntoInt(String input) {
        return Integer.parseInt(input);
    }

    private boolean isValidInput(String[] inputs) {
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String input : inputs) {
            try {
                int num = Integer.parseInt(input);
                if (num < 0) {
                    negativeNumbers.add(num);
                }
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        if (negativeNumbers.size() > 0) {
            StringBuilder negativeNumbersString = new StringBuilder();
            negativeNumbers.forEach(negativeNumber -> {
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
