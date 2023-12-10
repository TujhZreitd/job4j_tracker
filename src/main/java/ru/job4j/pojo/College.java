package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudent("Yakushev Egor Ivanovic");
        student.setNumberGroup(202);
        student.setAdmissionDate(new Date());

        System.out.println("ФИО студента: " + student.getStudent() + "\n" + "Номер группы студента: " + student.getNumberGroup() + "\n"
        + "Дата поступления студента: " + student.getAdmissionDate());
    }
}
