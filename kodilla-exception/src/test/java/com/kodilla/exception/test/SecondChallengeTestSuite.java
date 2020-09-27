package com.kodilla.exception.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {
    @Test
    void SecondChallengeTestWithOutException(){
        // given
        ExceptionHandling aExceptionHandling = new ExceptionHandling();
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        String test = aExceptionHandling.except(1 ,2);
        // then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.1 , 2));
        Assertions.assertEquals("Done!", test);
    }
    @Test
    void SecondChallengeTestWithYException(){
        // given
        ExceptionHandling aExceptionHandling = new ExceptionHandling();
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        String test = aExceptionHandling.except(1.1 ,1.5);
        // then
        assertThrows(ExceptionHandling.class , () -> secondChallenge.probablyIWillThrowException(1.1 , 1.5));
        Assertions.assertEquals("Exception", test);
    }
    @Test
    void SecondChallengeTestWithXException(){
        // given
        ExceptionHandling aExceptionHandling = new ExceptionHandling();
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        String test = aExceptionHandling.except(2 ,2);
        // then
        assertThrows(ExceptionHandling.class , () -> secondChallenge.probablyIWillThrowException(2 , 2));
        Assertions.assertEquals("Exception", test);
    }
}
