package ru.geekbrains.lesson7;

import java.util.Random;

public class Cat {

    private String name;
    private int stomachVolume;
    private int appetite;
    private int agility;
    private float activity;


    public float getActivity() {
        return activity;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public Cat(String name) {
        // при рождении кота требутся его имя
        // объем желудка вычисляется рандомом
        // ловкость определяется рандомом
        // аппертит определяем равный объему желудка
        // активность вычисляет как произведение аппетита и ловкости

        this.name = name;
        Random rnd = new Random();
        this.stomachVolume = 50 + rnd.nextInt(50);
        this.appetite = this.stomachVolume;
        this.agility = rnd.nextInt(100);
        this.activity  = (float)this.agility * (float)this.appetite;
    }


    @Override
    public String toString() {
        return  "name = \t\t\t" + name + '\n' +
                "stomachVolume = " + stomachVolume + '\n' +
                "appetite = \t\t" + appetite + '\n' +
                "agility = \t\t" + agility + '\n' +
                "activity = \t\t" + activity + '\n';
    }

    public void snapOff(Plate plate){
        int snap;
        snap = Math.min( this.abilityToSnap(), plate.getFood() );

        plate.decreaseFood(snap);
        appetite -= snap;
        agility -= (int)( (float)agility * (float)(stomachVolume - appetite)/ (float)stomachVolume );
        activity = appetite * agility;
    }

    private int abilityToSnap(){

        return Math.min( (10 + 10*(int)(((float)agility + (float)appetite*2.0f)/(float)stomachVolume)),
                         appetite );
    }



}
