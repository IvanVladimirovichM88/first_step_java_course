package ru.geekbrains.lesson4;

import java.util.Scanner;

public class MainLesson4 {

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    // габариты игрового поля playingField
    static final int HEIGHT = 6;
    static final int WIDTH = 6;

    static final int LINE_LENGTH = 4; // длина выигрышной линии

    public static void main(String[] args) {

        char[][] playingField;
        playingField = new char[HEIGHT][WIDTH];

        initializePlayingField(playingField);

        do {
            printPlayingField(playingField);
            userStep(playingField);
            if (isVictory(playingField,DOT_X)){
                printPlayingField(playingField);
                System.out.println("Победа человека!!!");
                break;
            }
            computerStep(playingField);
            if (isVictory(playingField,DOT_O)){
                printPlayingField(playingField);
                System.out.println("Победа компьютера!!!");
                break;
            }
        }while( !isDraw(playingField,DOT_EMPTY) );
        System.out.println("Игра окончена");
    }

    static void userStep(char[][] playingField){

        Scanner scanner = new Scanner(System.in);

        int i,j;
        do {
            System.out.print("введите число по вертикали - ");
            i = scanner.nextInt() - 1;
            System.out.print("введите число по горизонтали - ");
            j = scanner.nextInt() - 1;
        }while(!testValidation(playingField, i, j));
        playingField[i][j] = DOT_X;
    }

    static void computerStep(char[][] playingField){

        int[][] maxRiskForX = arrayOfMaxRisk(playingField,DOT_EMPTY,DOT_X);
        int[][] maxRiskForO = arrayOfMaxRisk(playingField,DOT_EMPTY,DOT_O);
        int[] maxValueForX = maxValueIAndJ(maxRiskForX);
        int[] maxValueForO = maxValueIAndJ(maxRiskForO);

        if (maxValueForO[0] == 3){
            playingField[ maxValueForO[1] ][ maxValueForO[2] ] = DOT_O;
        }else {
            playingField[ maxValueForX[1] ][ maxValueForX[2] ] = DOT_O;
        }
    }

    static boolean isVictory(char[][] playingField, final char DOT){
        int[][] arrayWinnings = arrayOfMaxRisk(playingField,DOT,DOT);
        int max = maxValueIAndJ(arrayWinnings)[0];

        return max == LINE_LENGTH - 1;
    }

    static boolean isDraw(char [][] playingField, final char DOT_EMPTY){

        boolean isDraw = true;

        for(int i = 0; i < playingField.length; i++){
            for(int j = 0; j < playingField[0].length; j++){
                if (playingField[i][j] == DOT_EMPTY){
                    isDraw = false;
                    break;
                }
            }
        }
        return isDraw;
    }

    static boolean testValidation(char[][] playingField, int i, int j){

        if(i>=0 && i<playingField.length && j>=0 && j<playingField[0].length){
            if(playingField[i][j] == '.'){
                return true;
            }
        }
        return false;

    }

    static void initializePlayingField(char [][] playingField){
        for(int i=0; i<playingField.length; i++){
            for (int j=0; j<playingField[i].length; j++){
                playingField[i][j] = '.';
            }
        }
    }

    static void printPlayingField (char[][] playingField){
        for(int i=0; i<=playingField[0].length; i++){
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i=0;i<playingField.length; i++){
            System.out.print((i+1)+" ");
            for (int j=0; j<playingField[i].length; j++){
                System.out.print(playingField[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] arrayOfMaxRisk(char [][] playingField, final char DOT_IN, final char DOT_SEEK){

        int[][] arrayOfRisk;
        int horizontalRisk;
        int verticalRisk;
        int mainDiagonalRisk;
        int sideDiagonalRisk;
        arrayOfRisk = new int[playingField.length][playingField[0].length];
        for (int i = 0; i < arrayOfRisk.length; i++) {
            for (int j = 0; j < arrayOfRisk[0].length; j++) {
                horizontalRisk = testHorizontalInOnePoint(playingField, DOT_IN, DOT_SEEK, i, j);
                verticalRisk = testVerticalInOnePoint(playingField, DOT_IN, DOT_SEEK, i, j);
                mainDiagonalRisk = testMainDiagonalInOnePoint(playingField, DOT_IN, DOT_SEEK, i, j);
                sideDiagonalRisk = testSideDiagonalInOnePoint(playingField, DOT_IN, DOT_SEEK, i, j);

                arrayOfRisk[i][j] = maxOfFour(horizontalRisk,verticalRisk,mainDiagonalRisk,sideDiagonalRisk);
            }
        }
        return arrayOfRisk;
    }

    static int testHorizontalInOnePoint(char[][] playingField, final char DOT_IN, final char DOT_SEEK,  int i, int j){

        int counter = 0;

        if(playingField[i][j] == DOT_IN){
            int step = j;
            while (step>0){
                step--;
                if (playingField[i][step] == DOT_SEEK){
                    counter++;
                }else {break;}
            }
            step = j;
            while(step<playingField[0].length-2){
                step++;
                if(playingField[i][step] == DOT_SEEK){
                    counter++;
                }else{break;}
            }
        }
        return counter;
    }

    static int testVerticalInOnePoint (char[][] playingField, final char DOT_IN, final char DOT_SEEK, int i, int j){

        int counter = 0;

        if(playingField[i][j] == DOT_IN){
            int step = i;
            while (step>0){
                step--;
                if (playingField[step][j] == DOT_SEEK){
                    counter++;
                }else {break;}
            }
            step = i;
            while(step<playingField.length-2){
                step++;
                if(playingField[step][j] == DOT_SEEK){
                    counter++;
                }else{break;}
            }
        }
        return counter;
    }

    static int testMainDiagonalInOnePoint(char[][] playingField,final char DOT_IN, final char DOT_SEEK, int i, int j){
        int counter = 0;

        if(playingField[i][j] == DOT_IN){
            int stepI = i;
            int stepJ = j;
            while (stepI>0 && stepJ>0){
                stepI--;
                stepJ--;
                if (playingField[stepI][stepJ] == DOT_SEEK){
                    counter++;
                }else {break;}
            }
            stepI = i;
            stepJ = j;
            while(stepI < playingField.length-2 && stepJ < playingField[0].length-2){
                stepI++;
                stepJ++;
                if(playingField[stepI][stepJ] == DOT_SEEK){
                    counter++;
                }else{break;}
            }
        }
        return counter;
    }

    static int testSideDiagonalInOnePoint(char[][] playingField, final char DOT_IN, final char DOT_SEEK, int i, int j){
        int counter = 0;

        if(playingField[i][j] == DOT_IN){
            int stepI = i;
            int stepJ = j;
            while (stepI < playingField.length-2 && stepJ>0){
                stepI++;
                stepJ--;
                if (playingField[stepI][stepJ] == DOT_SEEK){
                    counter++;
                }else {break;}
            }
            stepI = i;
            stepJ = j;
            while(stepI>0 && stepJ < playingField[0].length-2){
                stepI--;
                stepJ++;
                if(playingField[stepI][stepJ] == DOT_SEEK){
                    counter++;
                }else{break;}
            }
        }
        return counter;
    }

    static void printArrayInt(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j< array[0].length; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int maxOfFour(int one, int two, int three, int four){
        int max = one;
        if (max<two){max = two;}
        if (max<three){max = three;}
        if (max<four){max = four;}
        return max;
    }

    static int[] maxValueIAndJ(int[][] arrayOfValue){
        int[] maxValueIAndJ = { 0, 0, 0 };
        for(int i=0; i<arrayOfValue.length; i++){
            for(int j=0; j<arrayOfValue[0].length; j++){
                if (maxValueIAndJ[0] < arrayOfValue[i][j]){
                    maxValueIAndJ[0] = arrayOfValue[i][j];
                    maxValueIAndJ[1] = i;
                    maxValueIAndJ[2] = j;
                }
            }
        }
        return maxValueIAndJ;
    }

}
