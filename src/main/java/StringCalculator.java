class StringCalculator {

    int add(String allInputs) {
        String[] inputs = splitIntoInputs(allInputs);

        if (checkIfInputIsValid(inputs)) return 0;

        int sum = 0;
        for (String input : inputs) {
            sum += getIntValue(input);
        }
        return sum;
    }

    private boolean checkIfInputIsValid(String[] inputs) {
        for (String input : inputs) {
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                return true;
            }
        }
        return false;
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

    private int getIntValue(String input) {
        return Integer.parseInt(input);
    }
}
