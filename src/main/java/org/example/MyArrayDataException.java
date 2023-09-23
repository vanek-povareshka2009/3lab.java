package org.example;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j, String value){
        super("В матрице [" + (i+1) + "; "+ (j+1) +"]" + value + " находится символ.");
    }
}
