import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void should_return_zero_when_empty_string() {
        //Arrange
        String emptyString = "";

        //Act
        int result = Calculator.add(emptyString);

        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    void should_return_input_when_one_parameter() {
        //Arrange
        String param = "1";

        //Act
        int result = Calculator.add(param);

        //Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    void should_return_sum_when_two_parameters() {
        //Arrange
        String param = "1,2";

        //Act
        int result = Calculator.add(param);

        //Assert
        assertThat(result).isEqualTo(3);
    }

    @Test
    void should_return_sum_when_three_parameters() {
        //Arrange
        String param = "1,2,35";

        //Act
        int result = Calculator.add(param);

        //Assert
        assertThat(result).isEqualTo(38);
    }
}

