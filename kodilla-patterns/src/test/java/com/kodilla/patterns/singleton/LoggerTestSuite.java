package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger loger;

    @BeforeAll
    public static void openLoger(){
        loger = Logger.INSTANCE;
    }
    @Test
    void testLogAndGetLastLog(){
        //Given
        //When
        loger.log("Ala poszla wyrzucic smieci.");
        //Then
        assertEquals("Ala poszla wyrzucic smieci.", loger.getLastLog());
    }

}
