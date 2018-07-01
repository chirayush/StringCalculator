import java.util.Scanner;

class StringCalculator {

    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        Scanner scanner = buildScannerWithDelimiter(input);

        return sum(scanner);

    }

    private Scanner buildScannerWithDelimiter(String input) {
        String customDelimiter = "";
        boolean isCustomDelimiter = isCustomDelimiterPattern(input);
        if (isCustomDelimiter) {
            customDelimiter = String.valueOf(input.charAt(2));
            String initialPattern = "//" + customDelimiter + "\n";
            input = input.replace(initialPattern, "");
        }
        Scanner scanner = new Scanner(input);

        if (isCustomDelimiter) {
            scanner.useDelimiter(customDelimiter);
        } else {
            scanner.useDelimiter(",|\\n");
        }
        return scanner;
    }

    private boolean isCustomDelimiterPattern(String input) {
        return input.startsWith("//") && "\n".equals(input.substring(3, 4));
    }

    private int sum(Scanner scanner) {
        int sum = 0;
        while (scanner.hasNextInt()) {
            int currentNumber = scanner.nextInt();
            if (currentNumber < 0) {
                throw new IllegalArgumentException("negatives not allowed -3");
            }
            sum += currentNumber;
        }

        return sum;
    }
}
