package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseDecorator extends AbstractPizzaOrderDecorator{
    public ExtraCheeseDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(5.0));
    }
    public String getDescription(){
        return super.getDescription() + " + dodatkowy ser";
    }
}
