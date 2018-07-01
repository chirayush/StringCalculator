import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringCalculator {

    int add(String input) {
        if ("".equals(input)) {
            return 0;
        }

        String[] inputs;

        if (input.startsWith("//") && "\n".equals(input.substring(3, 4))) {
            String customDelimiter = String.valueOf(input.charAt(2));
            input = input.replace("//" + customDelimiter + "\n", "");
            inputs = input
                    .replace(customDelimiter, ",")
                    .split(",");
        } else {
            inputs = input
                    .replace("\n", ",")
                    .split(",");
        }

        List<Integer> negativeNumbers = new ArrayList<>();

        Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .forEach(num -> negativeNumbers.add(num));

        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
