package ru.geekbrains.lesson6;

//Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина,
// означающая или длину препятствия (для бега и плавания), или высоту (для прыжков)

public abstract class Animal {

    protected int canRun;
    protected int canSwim;
    protected float canJump;

    public abstract void run( int distance);
    public abstract void swim( int distance);
    public abstract void jump( float height);

    public void printAll(){
        System.out.println(" прыгает - " + canJump +
                    "\n бежит - " + canRun +
                    "\n плывет - " + canSwim);
    };

}
