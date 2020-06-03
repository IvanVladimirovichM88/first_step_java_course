package ru.geekbrains.lesson7;

import java.util.Arrays;

public class FlockOfCats {
    private Cat[] cats;
    private int number;

    public FlockOfCats(String[] nameOfCats){
        number = nameOfCats.length;
        cats = new Cat[number];
        for (int i=0; i<number; i++) {
            cats[i] = new Cat(nameOfCats[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder returnStr = new StringBuilder();
        for(int i=0; i<number; i++){
            returnStr.append(cats[i].toString());
        }
        return returnStr.toString();
    }

    private int getIndexCatWithMinActive(){
        int returnIndex = 0;
        for (int i=1; i < number; i++){
            if(cats[returnIndex].getActivity() > cats[i].getActivity()){
                returnIndex=i;
            }
        }
        return returnIndex;
    }

    public void snapOff(Plate plate){
        // кота с минимальной активностью не допускают к миске

        int minActive = this.getIndexCatWithMinActive();

        for (int i=0; (i<number)&(plate.getFood()>0) ; i++){
            if (i != minActive){
                cats[i].snapOff(plate);
            }
        }
    }

    private boolean hasHungry(){
        for (Cat cat :
                cats) {
            if (cat.getAppetite() > 0) {
                return true;
            }
        }
        return false;
    }

    public void attack(Plate plate){
        this.printFlock();
        do{
            this.snapOff(plate);
            System.out.println("Поели");
            plate.info();
            this.printFlock();
        }while(this.hasHungry() & plate.getFood() > 0);

        if( plate.getFood() == 0 & this.hasHungry()){
            System.out.println("\n===== КОТИКИ НАЧИНАЮТ ЕСТЬ ДРУГ ДРУГА !!! ======");
        }
    }

    public void printFlock(){
        for (int i =0; i< number; i++){
            System.out.println("имя  -  " + cats[i].getName() +
                                "\t аппетит - " + cats[i].getAppetite() +
                                "\t активность  - " + cats[i].getActivity());
        }
    }
}
