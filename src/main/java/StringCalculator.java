import java.util.Arrays;

final class StringCalculator {

    int add(final String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiterPattern = "[,\n]";

        if (input.startsWith("//")) {
            delimiterPattern += "|" + input.substring(2, 3);
        }

        return Arrays.stream(input.split(delimiterPattern))
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .filter(value -> value <= 1000)
                .sum();
    }
}
