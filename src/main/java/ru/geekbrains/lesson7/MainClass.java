package ru.geekbrains.lesson7;

public class MainClass {

    public static void main( String[] args){

        Plate plate = new Plate(500);
        String[] catsName = {"Vasek", "Kote", "Murzik", "Abormot"};

        FlockOfCats cats = new FlockOfCats(catsName);

        cats.attack(plate);

    }
}
