package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BigmacTestSuite {
    @Test
    void testNewBigmac(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .chooseBun(Bun.SESAME)
                .chooseSauce(Sauce.STANDARD)
                .quantityBurgers(2)
                .addIngredients(Ingredient.BACON)
                .addIngredients(Ingredient.MUSHROOMS)
                .addIngredients(Ingredient.CHILLI)
                .addIngredients(Ingredient.CHEESE)
                .build();
        //When
        System.out.println(bigmac);
        int numberOfIngredience = bigmac.getIngredients().size();
        //Then
        assertEquals(4, numberOfIngredience);
    }
    @Test
    void testNewBigmacWrong(){
        //Given
        //When
        //Then
        assertThrows(IllegalStateException.class, ()->new Bigmac.BigmacBuilder()
                .quantityBurgers(1)
                .addIngredients(Ingredient.PRAWNS)
                .build());
    }
}
