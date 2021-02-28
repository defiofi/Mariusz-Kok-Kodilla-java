package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AddOliveDecorator extends AbstractPizzaOrderDecorator{
    public AddOliveDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(3.0));
    }
    public String getDescription(){
        return super.getDescription() + " + oliwki";
    }
}
