package org.example;

public class Triangle {

    public static void main( String[] args ){


    }

    public static double triangleArea( int a, int b, int c )throws MyNegativeNumberException, MyZeroNumberException, MyTriangleDoesNotExistException{
        if(a<0 || b<0 || c<0) throw new MyNegativeNumberException("Число не может быть отрицательным");
        if(a==0 || b==0 || c==0) throw new MyZeroNumberException("Число не может быть 0");
        if(a+b<=c || a+c<=b || b+c<=a ) throw new MyTriangleDoesNotExistException("Числа не составляют треугольник");

        double p = (a + b + c) / 2.0;
        double result = Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c)) * 1000)/1000.0;
        return  result;
    }
}

