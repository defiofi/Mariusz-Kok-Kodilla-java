package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost(){
        // Given
        PizzaOrder theOrder = new BasicPizza();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15.0), calculatedCost);
    }
    @Test
    public void testBasicPizzaOrderGetDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizza();
        //When
        String theDescription = theOrder.getDescription();
        //Then
        assertEquals("Ciasto i sos pomidorowy z serem", theDescription);
    }
    @Test
    public void testAddHamGetCost(){
        //Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new AddHamDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(30.0), calculatedCost);
    }
    @Test
    public void testAddHamGetdescription(){
        //Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new AddHamDecorator(theOrder);
        //When
        String theDescription = theOrder.getDescription();
        //Then
        assertEquals("Ciasto i sos pomidorowy z serem + szynka", theDescription);
    }
    @Test
    public void testAddSeveralIngredientsGetCost(){
        //Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new AddSalamiDecorator(theOrder);
        theOrder = new AddOliveDecorator(theOrder);
        theOrder = new AddPineappleDocorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(42.0), calculatedCost);
    }
    @Test
    public void testAddSeveralIngrediensGetDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new AddSalamiDecorator(theOrder);
        theOrder = new AddOliveDecorator(theOrder);
        theOrder = new AddPineappleDocorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        String theDescription = theOrder.getDescription();
        //Then
        assertEquals("Ciasto i sos pomidorowy z serem + salami + oliwki + ananas + dodatkowy ser", theDescription);
    }
}

