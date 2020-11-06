package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations(){
        //Given
        final double a = 10;
        final double b = 5;
        //When
        double result1 = calculator.add(a, b);
        double result2 = calculator.sub(a, b);
        double result3 = calculator.mul(a, b);
        double result4 = calculator.div(a, b);
        //Then
        assertEquals(a+b, result1,0.000001);
        assertEquals(a-b, result2,0.000001);
        assertEquals(a*b, result3,0.000001);
        assertEquals(a/b, result4,0.000001);

    }
}
