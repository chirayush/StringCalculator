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
        return allInputs
                .replace("\n", ",")
                .split(",");
    }

    private int getIntValue(String input) {
        return Integer.parseInt(input);
    }
}
