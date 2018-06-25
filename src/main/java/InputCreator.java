import java.util.Arrays;
import java.util.stream.Stream;

class InputCreator {

    private final String allInputs;

    InputCreator(String allInputs) {
        this.allInputs = allInputs;
    }

    Stream<String> splitIntoInputs() {
        char delimiter = getCustomDelimiter();
        if (delimiter != ' ') {
            String customDelimitedInputs = allInputs
                    .substring(4)
                    .replace(String.valueOf(delimiter), ",");
            return splitIntoBasicInputs(customDelimitedInputs);
        }
        return splitIntoBasicInputs(allInputs);
    }

    private char getCustomDelimiter() {
        char delimiter = ' ';
        if (allInputs.startsWith("//")
                && "\n".equals(allInputs.substring(3, 4))) {
            delimiter = allInputs.charAt(2);
        }
        return delimiter;
    }

    private Stream<String> splitIntoBasicInputs(String delimitedInputs) {
        return Arrays.stream(delimitedInputs
                .replace("\n", ",")
                .split(","));
    }
}
