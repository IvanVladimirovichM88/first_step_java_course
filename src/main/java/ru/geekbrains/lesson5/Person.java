package ru.geekbrains.lesson5;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.lang.model.element.NestingKind;

public class Person {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String position;
    private String email;
    private String number;
    private float salary;
    private byte age;

    public Person(String lastName,
                  String firstName,
                  String patronymic,
                  String position,
                  String email,
                  String number,
                  float salary,
                  byte age){

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void printAllField(){

        System.out.println("Фамилия - \t" + lastName);
        System.out.println("Имя - \t\t" + firstName);
        System.out.println("Отчество - \t" + patronymic);
        System.out.println("Должность - " + position);
        System.out.println("Email - \t" + email);
        System.out.println("Телефон - \t" + number);
        System.out.println("Зарплата - \t" + salary);
        System.out.println("Возраст - \t" + age);
    }

    public byte getAge() {
        return age;
    }
}
