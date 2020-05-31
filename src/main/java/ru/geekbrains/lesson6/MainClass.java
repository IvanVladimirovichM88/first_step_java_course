package ru.geekbrains.lesson6;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class MainClass {
    public static void main(String[] args) {

        Dog arrayDogs[];
        arrayDogs = new Dog[5];
        Cat arrayCats[];
        arrayCats = new Cat[5];

        int counter  = 0;

        // инициализируем массив из Dog`s
        // и проверяем работу методов класса
        for (Dog dog :
                arrayDogs) {

            System.out.println("\tсобака - " + ++counter);

            dog = new Dog();
            dog.printAll();
            dog.jump(0.5f);
            dog.run(500);
            dog.swim(10);

            System.out.println();
        }

        counter = 0;

        // инициализируем массив из Cat`s
        // и проверяем работу методов класса
        for (Cat cat :
                arrayCats) {

            System.out.println("\tКошка - " + ++counter);

            cat = new Cat();
            cat.printAll();
            cat.jump(2.0f);
            cat.run(200);
            cat.swim(1);
            System.out.println();
        }
    }
}
