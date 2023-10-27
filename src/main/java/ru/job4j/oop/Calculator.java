package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int number) {
        return number - x;
    }

    public double divide(int dividend) {
        return (double) dividend / x;
    }

    public double sumAllOperation(int c) {
        return sum(c) + multiply(c) + minus(c) + divide(c);
    }

    public static void main(String[] args) {
        int resultMinus = minus(8);
        System.out.println(resultMinus);

        Calculator calculator = new Calculator();
        double resultDivide = calculator.divide(10);
        System.out.println(resultDivide);

        System.out.println(calculator.sumAllOperation(15));
    }
}
