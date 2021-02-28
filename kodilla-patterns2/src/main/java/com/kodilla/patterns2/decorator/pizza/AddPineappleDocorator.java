package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AddPineappleDocorator extends AbstractPizzaOrderDecorator{
    public AddPineappleDocorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(7.0));
    }
    public String getDescription(){
        return super.getDescription() + " + ananas";
    }
}
