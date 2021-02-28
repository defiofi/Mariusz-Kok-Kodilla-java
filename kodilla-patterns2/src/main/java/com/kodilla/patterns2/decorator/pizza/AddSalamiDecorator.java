package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AddSalamiDecorator extends AbstractPizzaOrderDecorator{
    public AddSalamiDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(12.0));
    }
    public String getDescription(){
        return super.getDescription() + " + salami";
    }
}
