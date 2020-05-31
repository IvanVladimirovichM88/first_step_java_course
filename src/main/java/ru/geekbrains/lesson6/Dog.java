package ru.geekbrains.lesson6;

// У каждого животного есть ограничения на действия
// (бег: собака 500 м.; прыжок: собака 0.5 м.; плавание: собака 10 м.)

import java.util.Random;

public class Dog extends Animal{

    public Dog(){
        Random rnd = new Random();

        //инициализируем поля прыжка бега и плавания с учетом разброса
        super.canJump = 0.4f + rnd.nextFloat()*0.2f;
        super.canRun = 400 + rnd.nextInt(200);
        super.canSwim = 5 + rnd.nextInt(10);
    }

    @Override
    public void jump(float height) {
        System.out.println( (super.canJump >= height) ?
                            "Эта собака перепрыгнет припятствие - " + height
                            :"Эта собака НЕ перепрыгнет препятствие - " + height);
    }

    @Override
    public void run(int distance) {
        System.out.println( (super.canRun >= distance) ?
                "Эта собака пробежит дистанцию - " + distance
                :"Эта собака НЕ пробежит дистанцию - " + distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println( (super.canSwim >= distance) ?
                "Эта соба проплывет дистанцию - " + distance
                :"Эта собака НЕ проплывет дистанцию - " + distance);

    }
}
