package com.kodilla.exception.test;

public class ExceptionHandling {
    public String except(double x, double y){
        SecondChallenge aSecondChallenge = new SecondChallenge();
        try{
        return aSecondChallenge.probablyIWillThrowException(x,y);
        }
        catch(Exception e){
            return "Exception";
        }
    }
}