package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudent("Yakushev Egor Ivanovic");
        student.setNumberGroup(202);
        student.setAdmissionDate(new Date());

        System.out.println("ФИО студента: " + student.getStudent() + System.lineSeparator() + "Номер группы студента: " + student.getNumberGroup() + System.lineSeparator()
        + "Дата поступления студента: " + student.getAdmissionDate());
    }
}
