package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        System.out.println("выберите игру: 1 - угадай цифру, 2 - угадай слово");
        Scanner sc = new Scanner(System.in);
        int userChoice;

        do {
            userChoice = sc.nextInt();
        }while(!(userChoice==1 || userChoice==2));

        switch (userChoice){
            case (1):
                do {
                    System.out.println("Угодай число от 0 до 9");
                }while(gameNumber()>0);
                break;
            case (2):
                gameWords();
                break;
        }

    }

    static int gameNumber(){

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int originalNumber = rnd.nextInt(10);
        int userNumber;
        int counter = 0;
        do{
            userNumber = sc.nextInt();
            if (userNumber == originalNumber){
                System.out.println("Победа!");
                break;
            }else if (userNumber < originalNumber){
                System.out.println("Загаданное число больше");
            }else {
                System.out.println("Загаданное число меньше");
            }
            counter++;
        }while(counter<3);

        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int userAnswer;

        do {
            userAnswer = sc.nextInt();
        }while ( userAnswer < 0 || userAnswer > 1);

        sc.close();

        return userAnswer;
    }

    static int numberOfCoincidences(String originalStr, String userStr, char[] outLine){

        int position = 0;
        int coincidence = 0;
        do{

            if (originalStr.charAt(position) == userStr.charAt(position)){
                outLine[position] = userStr.charAt(position);
                coincidence++;
            }
            position++;
        }while(position < userStr.length() && position < originalStr.length() );

        return coincidence;
    }

    static void gameWords(){

        String[] words =
                {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                 "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                 "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                 "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        char [] outLine = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int numberOfWord = rnd.nextInt(words.length);
        String userSrt;

        System.out.println("угадайте загаданное слово");
        userSrt = sc.nextLine();


        while (numberOfCoincidences(words[numberOfWord],userSrt,outLine) < words[numberOfWord].length()){
            System.out.println("угаданы следующие буквы:");
            System.out.println(outLine);
            System.out.println("продолжайте угадывать");
            userSrt = sc.nextLine();
        }
        System.out.println("вы угадали!");

        sc.close();
    }

}
