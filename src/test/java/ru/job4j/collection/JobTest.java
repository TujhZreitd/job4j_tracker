package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAsc() {
        int rsl = new JobAscByName().compare(
                new Job("Eqwe", 1),
                new Job("Rteq", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByPriorityAsc() {
        int rsl = new JobAscByPriority().compare(
                new Job("Eqwe", 1),
                new Job("Rteq", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        int rsl = new JobDescByPriority().compare(
                new Job("Eqwe", 1),
                new Job("Rteq", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameDesc() {
        int rsl = new JobDescByName().compare(
                new Job("Eqwe", 1),
                new Job("Rteq", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameAndPrority2() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}