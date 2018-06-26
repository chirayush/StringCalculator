import java.util.Scanner;

class StringCalculator {

    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String customDelimiter = " ";
        if (input.startsWith("//") && "\n".equals(input.substring(3, 4))) {
            customDelimiter = String.valueOf(input.charAt(2));
            String initialPattern = "//" + customDelimiter + "\n";
            input = input.replace(initialPattern, "");
        }
        Scanner scanner = new Scanner(input);

        if(customDelimiter.equals(" ")) {
            scanner.useDelimiter(",|\\n");
        } else {
            scanner.useDelimiter(customDelimiter);
        }

        return sum(scanner);

    }

    private int sum(Scanner scanner) {
        int sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
        }

        return sum;
    }
}
