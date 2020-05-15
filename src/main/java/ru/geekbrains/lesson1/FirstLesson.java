package ru.geekbrains.lesson1;

public class FirstLesson {
    public static void main(String[] args) {
        // 1. создаем переменные всех пройденых типов и инициализируем их
        byte byVal = 100;
        short shVal = 32000;
        int iVal = 2047483648;
        long lgVal = 10L;
        float flVal = 12.23f;
        double dbVal = -123.123;
        char cVal = '+';
        boolean blVal = false;

        //2. провверка метода  вычисляющего a*(b+(c/d))
        float a = 10f;
        float b = 15f;
        float c = 25f;
        float d = 5;
        System.out.println(calc(a,b,c,d) + "<--- должно получиться 200");

        //3. проверка метода определяющего где лежит сумма его параметров
        System.out.println(chek(5,10) + "<-- должно быть true");
        System.out.println(chek(11,10) + "<-- должно быть false");
        System.out.println(chek(1,2) + "<-- должно быть false");

        //4. проверка метода печатающего положительное или отрицательное число
        //ему передано и результат печатает в консоль
        testPrintConsole(10);
        testPrintConsole(-1);

        //5. проверка метода выводящего true в случае отрицательного числа false
        // в противном случае
        System.out.println(testRetBool(5) + "должно быть false");
        System.out.println(testRetBool(-2) + "должно быть true");

        //6. соединяем стоку "Привет, " с параметром переданным в методе
        sumSting("Василий");

        //7. проверка метода определяющего високосный год или нет
        System.out.println(yearTest(2000) + " - високосный");
        System.out.println(yearTest(1233) + " - простой");
    }

    // методы

    // метод вычисляет выражение a*(b+(c/d))
    public static float calc(float a, float b, float c, float d){
        return a*(b+(c/d));
    }

    //принимает на входе два числа, и проверяет дто их сумма лежит в пределах от 10 до 20
    //включительно, если да - то true в противном случае - false
    public static boolean chek(int a, int b){
        return ((a+b)<=20 && (a+b)>=10);
    }

    //метод получает на входе число и определяет положительное число или отрицательное
    //при этом ноль считается положитеьным
    public static void testPrintConsole(int a){
        if (a<0) {
            System.out.println(a + " - отрицательное число");
        }else {
            System.out.println(a + " - положительное число");
        }
    }

    // возвращает true если число отрицательное и false если число положительное
    public static boolean testRetBool(int a){
        return (a<0);
    }

    // выводит в консоль привет + имя из параметр методо
    public static void sumSting(String name){
        System.out.println("Привет, " + name + "!");
    }

    //определяет високосный год или нет true елси високосный в противном случае false
    public static boolean yearTest(int year){
        return (year % 4==0)&&!(year % 100 == 0) || (year % 400 == 0);
    }
}
