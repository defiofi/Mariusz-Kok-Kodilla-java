package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User adam = new Millenials("Adam Maliniak");
        User bartek = new YGeneration("Bartosz Kotuszewicz");
        User cezary = new ZGeneration("Cezary Szpotanski");
        //When
        System.out.println("testDefaultSharingStrategies:");
        String adamUse = adam.Publisher();
        System.out.println(adam.getUserName()+" uzywa "+adamUse);
        String bartekUse = bartek.Publisher();
        System.out.println(bartek.getUserName()+" uzywa "+bartekUse);
        String cezaryUse = cezary.Publisher();
        System.out.println(cezary.getUserName()+" uzywa "+cezaryUse);
        //Then
        assertEquals("Facebook", adamUse);
        assertEquals("Twitter", bartekUse);
        assertEquals("Snapchat", cezaryUse);
    }
    @Test
    void testIndividualSharingStrategy(){
        //Given
        User adam = new Millenials("Adam Maliniak");
        //When
        System.out.println("testIndividualSharingStrategy:");
        String adamUse = adam.Publisher();
        System.out.println(adam.getUserName()+" uzywa "+adamUse);
        adam.setSocialPublisher(new TwitterPublisher());
        adamUse = adam.Publisher();
        System.out.println(adam.getUserName()+" uzywa po zmianie "+adamUse);
        //Then
        assertEquals("Twitter", adamUse);
    }
}
