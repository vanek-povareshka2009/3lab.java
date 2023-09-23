package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"879", "4", "47","11"},
                {"7", "5", "9", "21"},
                {"1", "34", "5", "89"},
                {"15", "4", "55","196"}
        };

        try {
            System.out.println("Сумма чисел матрицы: " + method(array));
        }
        catch (MyArraySizeException | MyArrayDataException | MyLychrelException e){
                e.printStackTrace();
        }
    }
    public static int method(String[][] array) throws MyArraySizeException, MyArrayDataException, MyLychrelException {

        if(array.length != 4){
            throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4){
                throw new MyArraySizeException();
            }
        }
        int number;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j,array[i][j]);
                }

                try {
                    if (isLychrel(number)) {
                        throw new MyLychrelException(i, j, number);
                    }
                } catch (MyLychrelException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }
    public static String reversed(int number) {
        if (number >= 10 && number <= 1000) {
            int reversedValue = Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
            return String.valueOf(reversedValue);
        }
        return String.valueOf(number);
    }

    public static boolean isPalindrome(int number) {
        String stringValue = String.valueOf(number);
        String reversedValue = new StringBuilder(stringValue).reverse().toString();
        return stringValue.equals(reversedValue);
    }

    public static boolean isLychrel(int number) {
        int iterations = 0;
        while (iterations < 30) {
            String reversedValue = reversed(number);
            int intValue = Integer.parseInt(reversedValue);
            number += intValue;
            if (number <= 1000 && isPalindrome(number)) {
                return false;
            }
            iterations++;
        }
        return true;
    }
}

