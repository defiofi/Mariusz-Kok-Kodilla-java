package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage(){
        //Given
        int [] exampleTable = {1 , 15 , 32 , 42 , 71 , 12 , 30 , 16 , 56 , 82 , 73 , 41 , 34 , 96 , 102, 401 , 111 , 9 , 13 , 23};
        final double  pattern = (1 + 15 + 32 + 42 + 71 + 12 + 30 + 16 + 56 + 82 + 73 + 41 + 34 + 96 + 102 + 401 + 111 + 9 + 13 + 23)/20;
        //When
        Double reply = ArrayOperations.getAverage(exampleTable);
        //Then
        System.out.println(pattern);
        assertEquals(pattern, reply);
    }
}
