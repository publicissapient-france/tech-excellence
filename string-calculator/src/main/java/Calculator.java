import java.util.Arrays;

public class Calculator {

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if (input.contains(",")) {
            String[] numbers = input.split(",");
            return Arrays.asList(numbers).stream()
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
        }

        return Integer.parseInt(input);
    }
}
