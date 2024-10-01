package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteTest {
    @Test
    public void whenDeleteItem() {
        Output output = new Stub();
        Store tracker = new MemTracker();
        Item item = new Item("Name");
        tracker.add(item);
        int idItem = item.getId();
        UserAction delete = new Delete(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(idItem);

        delete.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

}