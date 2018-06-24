import java.security.InvalidParameterException;

class StringCalculator {

    int add(String allInputs) {
        String[] inputs = splitIntoInputs(allInputs);

        return sumInputs(inputs);
    }

    private int sumInputs(String[] inputs) {
        int sum = 0;
        for (String input : inputs) {
            sum += convertIntoInt(input);
        }
        return sum;
    }

    private int convertIntoInt(String input) {
        try {
            if (input.length() == 0) {
                return 0;
            }
            int num = Integer.parseInt(input);
            if (num < 0) {
                throw new InvalidParameterException("Negatives Not allowed -> " + num);
            }
            return num;
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private String[] splitIntoInputs(String allInputs) {
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

    private String[] splitIntoBasicInputs(String allInputs) {
        return allInputs
                .replace("\n", ",")
                .split(",");
    }
}
