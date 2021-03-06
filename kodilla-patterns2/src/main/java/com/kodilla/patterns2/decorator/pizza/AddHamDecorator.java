package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AddHamDecorator extends AbstractPizzaOrderDecorator{
    public AddHamDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(15.0));
    }
    public String getDescription(){
        return super.getDescription() + " + szynka";
    }
}
