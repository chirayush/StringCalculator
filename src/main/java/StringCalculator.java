import java.util.ArrayList;
import java.util.List;
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
        List<Integer> negativeNumbersList = new ArrayList<>();
        int sum = 0;
        while (scanner.hasNextInt()) {
            int currentNumber = scanner.nextInt();
            if (currentNumber < 0) {
                negativeNumbersList.add(currentNumber);
            } else if (currentNumber < 1001) {
                sum += currentNumber;
            }
        }
        handleNegativeNumbers(negativeNumbersList);

        return sum;
    }

    private void handleNegativeNumbers(List<Integer> negativeNumbersList) {
        if (!negativeNumbersList.isEmpty()) {
            StringBuilder negativeString = new StringBuilder();
            for (int negNum : negativeNumbersList) {
                negativeString.append(negNum).append(" ");
            }
            throw new IllegalArgumentException("negatives not allowed " + negativeString);
        }
    }
}
