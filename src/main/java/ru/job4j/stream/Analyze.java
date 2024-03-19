package ru.job4j.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Double.compare;
import static java.lang.Double.sum;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(subject -> subject.score())
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.name(), pupil.subjects().stream()
                        .mapToInt(subject -> subject.score())
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
         return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(subject -> subject.name(), LinkedHashMap::new, Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(name -> new Tuple(name.getKey(), name.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                                                                .stream()
                                                                .mapToInt(Subject::score)
                                                                .sum()))
                .max((turple1, turple2) -> compare(turple1.score(), turple2.score()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(subject -> subject.name(), LinkedHashMap::new, Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(name -> new Tuple(name.getKey(), name.getValue()))
                .max((turple1, turple2) -> compare(turple1.score(), turple2.score()))
                .orElse(null);
    }
}
