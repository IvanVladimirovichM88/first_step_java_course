package ru.geekbrains.lesson2;

import java.util.Arrays;

public class SecondLesson {
    public static void main(String[] args) {
        //1. проверка меода замены 0 на 1 и 1 на 0
        System.out.println("\n проверка задания 1");
        int [] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        replacement(array);
        System.out.println(Arrays.toString(array));

        //2. проверка метода создания массива с шагом изменения элементов - 3
        System.out.println("\n проверка задания 2");
        printGenArray(8);

        // 3. проверка метода прохода и увелиечения в случае
        // если элемент меньше 6
        System.out.println("\n проверка задания 3");
        array = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        passAndIncrease(array);
        System.out.println(Arrays.toString(array));

        //4. проверка метода замены диаганали в квадратном двумерном массиве на 1
        System.out.println("\n проверка задания 4");
        printCreatedTable(5);

        // 5. проверка метода поиска минимального и максимального значения в массиве
        System.out.println("\n проверка задания 5");
        printMinAndMax(array);

        // 6. проверка метода определяющего есть ли в массиве место где сумма правой и лево части равны
        System.out.println("\n проверка задания 6");
        System.out.println( "исходный массив \n" + Arrays.toString(array));
        System.out.println(hasCheckBalance(array));
        array = new int[] {2,2,2,2,4,4};
        System.out.println( "исходный массив \n" + Arrays.toString(array));
        System.out.println(hasCheckBalance(array));
        array = new int[] {20,1,1,2,4,4};
        System.out.println( "исходный массив \n" + Arrays.toString(array));
        System.out.println(hasCheckBalance(array));

        // 7. проверка метода сдвига массива на n элементов
        System.out.println("\n проверка задания 7");
        int step = 2;
        System.out.println( "исходный массив \n" + Arrays.toString(array));
        shiftArray(array,step);
        System.out.println( "модифицированный массив, шаг сдвига "+ step +" \n" + Arrays.toString(array));
        step = -2;
        shiftArray(array,step);
        System.out.println( "модифицированный массив, шаг сдвига "+ step +" \n" + Arrays.toString(array));
        step = 0;
        shiftArray(array,step);
        System.out.println( "модифицированный массив, шаг сдвига "+ step +" \n" + Arrays.toString(array));
    }



    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например:[ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0
    public static void replacement( int[] array){
        for (int i=0;i<array.length;i++) {
            if (array[i] == 0) {
                array[i] = 1;
            }else{
                array[i] = 0;
            }
        }
    }

    //Задать пустой целочисленный массив размером 8.
    //С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void printGenArray(int len){
        int [] array = new int [len];
        for (int i=0; i<len; i++){
            array[i]=i*3;
        }
        System.out.println(Arrays.toString(array));
    }

    //3. адать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2
    public static void passAndIncrease(int [] array){
        for (int i=0; i<array.length; i++){
            if (array[i] < 6){
                array[i] *=2;
            }
        }
    }


    // 4. Создать квадратный двумерный целочисленный массив
    // (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    // заполнить его диагональные элементы единицами
    public static void printCreatedTable(int size){
        int [][] table = new int[size][size];

        System.out.println("Print table");

        //создаем квадратный двумерный целочисленный массив
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                table[i][j] = i+j;
            }
            System.out.println(Arrays.toString(table[i]));
        }

        System.out.println("Print modified table");

        //заменяем диаганаль на 1
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if (i==j) {
                    table[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(table[i]));
        }

    }

    // 5. Задать одномерный массив и найти в нем минимальный и максимальный
    // элементы (без помощи интернета)
    public static void printMinAndMax(int [] array){
        int min = array[0], max = array[0];
        for(int i=1; i<array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
            if(max < array[i]){
                max = array[i];
            }
        }
        System.out.println("исходный массив \n" + Arrays.toString(array));
        System.out.println("минимальный элемент массива - " + min);
        System.out.println("максимальный элемент массива - " + max);
    }

    // 6. Написать метод, в который передается не пустой одномерный
    // целочисленный массив, метод должен вернуть true, если в массиве есть место,
    // в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят
    public static boolean hasCheckBalance(int [] array){

        for (int mirror = 1; mirror < array.length; mirror++){
            int sumFront = 0, sumEnd = 0;
            for(int iFront = 0; iFront < mirror; iFront++) {
                sumFront += array[iFront];
            }
            for(int iEnd = mirror; iEnd < array.length; iEnd++) {
                sumEnd += array[iEnd];
            }
            if (sumEnd == sumFront){
                //System.out.println(mirror);
                return true;
            }
        }
        return false;
    }

    //Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен
    // сместить все элементымассива на n позиций. Для усложнения задачи нельзя
    // пользоваться вспомогательными массивами
    public static void  shiftArray(int [] array, int step){
        if (step>0){
            int endElement;
            do{
                endElement = array[array.length-1];
                for(int i=array.length-2; i >= 0; i--){
                    array[i+1]=array[i];
                }
                array[0]=endElement;
                step--;
            }while(step!=0);
        }
        if (step<0){
            int firstElement;
            do{
                firstElement = array[0];
                for(int i=1;i<array.length;i++){
                    array[i-1]=array[i];
                }
                array[array.length-1] = firstElement;
                step++;
            }while (step!=0);
        }
    }

}

