package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {
    LETTUCE("lettuce"),
    ONION("onion"),
    BACON("bacon"),
    CUCUMBER("cucumber"),
    CHILLI("chilli peppers"),
    MUSHROOMS("mushrooms"),
    PRAWNS("prawns"),
    CHEESE("cheese");

    private String ingredient;

    Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }
    @Override
    public String toString(){
        return ingredient;
    }
}
