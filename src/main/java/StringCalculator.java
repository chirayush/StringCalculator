import java.util.function.Supplier;
import java.util.stream.Stream;

class StringCalculator {

    int add(String allInputs) {
        InputCreator inputCreator = new InputCreator(allInputs);
        Supplier<Stream<String>> supplierInputStream = inputCreator::splitIntoInputs;

        try {
            ErrorHandler errorHandler = new ErrorHandler(supplierInputStream.get());
            if (!errorHandler.isValidInput()) return 0;
        } catch (NumberFormatException ex) {
            return 0;
        }

        return supplierInputStream.get()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
