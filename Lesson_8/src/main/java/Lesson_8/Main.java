package Lesson_8;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    // Метод для проверки размера массива и суммирования элементов
    public static void checkAndSumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Array should be 4x4, but has " + array.length + " rows.");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Array should be 4x4, but has a row with " + row.length + " columns.");
            }
        }

        // Суммирование элементов массива
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data at (" + i + "," + j + "): " + array[i][j]);
                }
            }
        }
        System.out.println("Array sum is: " + sum);
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"10", "11", "12"}
        };

        String[][] incorrectDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            checkAndSumArray(correctArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkAndSumArray(incorrectSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkAndSumArray(incorrectDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Elements in the array are:");
        System.out.println(Arrays.deepToString(correctArray));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of the required element : ");
        try {
            System.out.print("x=");
            int x = sc.nextInt();
            System.out.print("y=");
            int y = sc.nextInt();
            System.out.println("Element in the given index is : " + correctArray[x][y]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index you have entered is invalid");
            System.out.println("Please enter an index number between 0 and 3");
        }
    }

}

