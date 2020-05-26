package ru.geekbrains.lesson5;

public class MainClass {
    public static void main(String[] args) {

        Person[] personArray = new Person[5];

        personArray[0] = new Person("Иванов","Федор", "Степанович",
                "дворник","ivanov@mail.ru", "27-34",
                100.50f, (byte) 95);

        personArray[1] = new Person("Петров","Константин", "Иванович",
                "завхоз","petrov@mail.ru", "10-30",
                200.50f, (byte) 60);

        personArray[2] = new Person("Сидорчук","Игнат", "Сулейманович",
                "Главбух","Sidorchuk@mail.ru", "32-40",
                2500.50f, (byte) 35);

        personArray[3] = new Person("Брынза","Галина", "Евгеньевна",
                "секретарша","Cheese@mail.ru", "30-30",
                5000.50f, (byte) 19);

        personArray[4] = new Person("Хорьх","Филипп", "Гаврилович",
                "директор","Horh@mail.ru", "10-00",
                25000.50f, (byte) 45);

        for (Person persona : personArray){
            if (persona.getAge() >= 40){
                persona.printAllField();
                System.out.println();
            }
        }
    }

}
