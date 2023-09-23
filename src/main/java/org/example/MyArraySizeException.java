package org.example;
public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Размер матрицы не соответсвует заданию!");

    }
}
