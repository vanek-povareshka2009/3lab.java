package org.example;


public class MyLychrelException extends RuntimeException{

    public MyLychrelException(int i, int j, int number){
        super("В матрице в строке [" + (i+1) + "] в столбце ["+ (j+1) +"] лежит число" + number + " которое является числом Лихрела");
    }

}
