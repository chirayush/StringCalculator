import java.util.Arrays;

final class StringCalculator {

    int add(final String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String customDelimiter = "[,\\n]";
        if (input.startsWith("//")) {
            customDelimiter += "|" + input.substring(2, 3);
        }

        return Arrays.stream(input.split(customDelimiter))
                .filter(s -> s.matches("-?\\d+"))
                .mapToInt(Integer::parseInt)
                .peek(x -> {
                    if (x < 0) throw new IllegalArgumentException("negatives not allowed " + x);
                })
                .filter(s -> s <= 1000)
                .sum();
    }
}
