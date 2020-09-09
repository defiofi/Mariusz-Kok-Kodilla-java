package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;
public class TestingMain {
    public static void main(String[] args){
        System.out.println("\nTest - pierwszy test jednostkowy klasy SimpleUser:");
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        if(result.equals("theForumUser"))   System.out.println("test OK");
        else    System.out.println("Error!");

        System.out.println("\nTest - pierwszy test jednostkowy klasy Calkulator:");
        Calculator calculator = new Calculator();
        int licz1 = 10 ;
        int licz2 = 20 ;
        int wynik = calculator.add(licz1 , licz2);
        if (wynik == licz1+licz2)    System.out.println("test OK");
        else    System.out.print("Error metody add");
        System.out.println("\nTest - drugi test jednostkowy klasy Calkulator:");
        wynik = calculator.subtract(licz1 , licz2);
        if (wynik == licz1-licz2)   System.out.println("test OK");
        else    System.out.print("Error metody subtract");
    }
}
