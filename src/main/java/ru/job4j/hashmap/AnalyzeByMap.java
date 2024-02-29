package ru.job4j.hashmap;

import java.util.*;

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
        int quantityPupils = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubjects.put(subject.name(), scoreBySubjects.getOrDefault(subject.name(), 0) + subject.score());
            }
            quantityPupils++;
        }
        for (String subject : scoreBySubjects.keySet()) {
            result.add(new Label(subject, scoreBySubjects.get(subject) / quantityPupils));
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
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubjects.put(subject.name(), scoreBySubjects.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String subject : scoreBySubjects.keySet()) {
            result.add(new Label(subject, scoreBySubjects.get(subject)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
