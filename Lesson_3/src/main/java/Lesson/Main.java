package Lesson;

public class Main {
    public static void main(String[] args) {
        //1
        printThreeWords();
        //2
        checkSumSign();
        //3
        printColor();
        //4
        compareNumbers();
        //5
        System.out.println(isSumTwo(11, 7));
        //6
        printPositive(5);
        //7
        System.out.println(isNegative(-6));
        //8
        printString("Hello World!", 15);
        //9
        System.out.println(printYear(1988));
        //10
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeArray(array);
        //11
        int[] a = new int[100];
        isArray(a);
        //12
        int[] array1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        modifyArray(array1);
        //13
        int[][] massive = new int[5][5];
        printDiagonal(massive);
        //14
        createArray(12, 5);

    }


    public static void printThreeWords() {
        System.out.println("Первое задание\n");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }


    public static void checkSumSign() {
        System.out.println("\nВторое задание\n");
        int a, b, sum;
        a = 12;
        b = -15;
        sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");

        } else {
            System.out.println("Сумма  отрицательная");
        }

    }


    public static void printColor() {
        System.out.println("\nЗадание третье\n");
        int value = 99;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers() {
        System.out.println("\nЗадание четвертое\n");
        int a, b;
        a = 207;
        b = 19;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a<b");
        }
    }


    public static boolean isSumTwo(int a, int b) {
        System.out.println("\nЗадание пять\n");
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    public static void printPositive(int a) {
        System.out.println("\nЗадание шесть\n");
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        System.out.println("\nЗадание семь\n");
        return a <= 0;
    }

    public static void printString(String str, int a) {
        System.out.println("\nЗадание восемь\n");
        for (int i = 0; i < a; i++) {
            System.out.println(str);

        }
    }


    public static boolean printYear(int a) {
        System.out.println("\nЗадание девять\n");
        return ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0));

    }


    public static void changeArray(int[] args) {
        System.out.println("\nЗадание десять\n");
        for (int i = 0; i < args.length; i++) {
            if (args[i] == 0) {
                args[i] = 1;
            } else {
                args[i] = 0;
            }
            System.out.print((args[i]) + " ");
        }
        System.out.println();
    }

    public static void isArray(int[] array) {
        System.out.println("\nЗадание одиннадцать\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print((array[i] = i + 1) + " ");
        }
        System.out.println();
    }


    public static void modifyArray(int[] array) {
        System.out.println("\nЗадание двенадцать\n");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                System.out.print((array[i] *= 2) + " ");
            } else {
                System.out.print((array[i]) + " ");
            }
        }
        System.out.println();

    }


    public static void printDiagonal(int[][] array) {
        System.out.println("\nЗадание тринадцать\n");
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                if (i + j + 1 == array.length || i == j) {
                    System.out.print((array[i][j] = 1));
                } else {
                    System.out.print((array[i][j]));
                }

            }
            System.out.println();
        }
    }


    public static int[] createArray(int len, int initialValue) {
        System.out.println("\nЧетырнадцатое задание\n");
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.print(newArr[i] = initialValue);
        }
        return newArr;
    }


}
