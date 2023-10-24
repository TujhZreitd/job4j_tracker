package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball egor = new Ball();
        Hare anton = new Hare();
        Fox liza = new Fox();
        Wolf ivan = new Wolf();
        anton.tryEat(egor);
        ivan.tryEat(egor);
        liza.tryEat(egor);
    }
}
