package com.kodilla.exception.test;

public class FirstChallengeTry {
    public double divide(double a, double b) throws ArithmeticException{
        try {
            return a/b;
        }
        catch(ArithmeticException e){
            return (a>=0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);

        }
    }
    public static void main(String[] args) {

        FirstChallengeTry firstChallenge = new FirstChallengeTry();
        double result = firstChallenge.divide(3, 0);
        System.out.println(result);
        result = firstChallenge.divide(-3, 0);
        System.out.println(result);
        result = firstChallenge.divide(3, 1000);
        System.out.println(result);

    }
}
