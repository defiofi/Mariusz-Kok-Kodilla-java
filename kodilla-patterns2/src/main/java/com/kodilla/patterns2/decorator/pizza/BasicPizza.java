package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizza implements PizzaOrder{
    @Override
    public BigDecimal getCost(){
        return new BigDecimal(15.0);
    }
    @Override
    public String getDescription(){
        return new String("Ciasto i sos pomidorowy z serem");
    }
}
