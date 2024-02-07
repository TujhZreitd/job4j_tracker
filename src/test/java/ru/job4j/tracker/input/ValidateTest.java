package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.*;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateTest {

    @Test
    void whenInvalidInput() {
        Output output = new Stub();
        Input in = new Mock(
                new String[]{"one", "1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenCorrectInput() {
        Output output = new Stub();
        Input in = new Mock(
                new String[]{"1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenManyCorrectInput() {
        Output output = new Stub();
        String[] inputData = new String[]{"2", "5", "3", "1"};
        Input in = new Mock(inputData);
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenNegativeNumberInput() {
        Output output = new Stub();
        Input in = new Mock(
                new String[]{"-1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}