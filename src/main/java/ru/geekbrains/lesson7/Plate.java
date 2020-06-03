package ru.geekbrains.lesson7;

public class Plate {
    private int food;

    public Plate (int food){
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void info(){
        System.out.println( "В тарелке осталось - " + food);
    }

    public void decreaseFood(int pieces){
        food -= pieces;
    }

    public void addSomeFood(int add){
        food += add;
    }

}
