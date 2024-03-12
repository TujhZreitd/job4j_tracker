package ru.job4j.hashmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int quantitySubjects = 0;
        double sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                quantitySubjects++;
            }
        }
        return sumScore / quantitySubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            int quantitySubjects = 0;
            double sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                quantitySubjects++;
            }
            result.add(new Label(pupil.name(), sumScore / quantitySubjects));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> scoreBySubjects = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> biFunction = (oldValue, newValue) -> oldValue + newValue;
        int quantityPupils = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubjects.merge(subject.name(), subject.score(), biFunction);
            }
            quantityPupils++;
        }
        for (Map.Entry<String, Integer> entry : scoreBySubjects.entrySet()) {
            Label label = new Label(entry.getKey(), entry.getValue() / quantityPupils);
            result.add(label);
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            result.add(new Label(pupil.name(), sumScore));
        }
        result.sort(Label::compareTo);
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> scoreBySubjects = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        BiFunction<Integer, Integer, Integer> biFunction = (oldValue, newValue) -> oldValue + newValue;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubjects.merge(subject.name(), subject.score(), biFunction);
            }
        }
        for (String subject : scoreBySubjects.keySet()) {
            result.add(new Label(subject, scoreBySubjects.get(subject)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
