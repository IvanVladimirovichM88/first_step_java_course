package ru.geekbrains.lesson6;

//У каждого животного есть ограничения на действия
// (бег: кот 200 м; прыжок: кот 2 м; плавание: кот не умеет плавать).

import java.util.Random;

public class Cat extends Animal {

    public Cat() {

        Random rnd = new Random();
        //инициализируем поля прыжка бега с учетом разброса
        //поле плавания правниваем 0
        super.canJump = 1.5f + rnd.nextFloat();
        super.canRun = 150 + rnd.nextInt(100);
        super.canSwim = 0;
    }

    @Override
    public void jump(float height) {
        System.out.println((super.canJump >= height) ?
                "Эта кошка перепрыгнет припятствие - " + height
                : "Эта кошка НЕ перепрыгнет препятствие - " + height);
    }

    @Override
    public void run(int distance) {
        System.out.println((super.canRun >= distance) ?
                "Эта кошка пробежит дистанцию - " + distance
                : "Эта кошка НЕ пробежит дистанцию - " + distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println( "Кошки не плавают, совсем!!!");

    }
}
