package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryShopping(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.makeTask(TaskFactory.SHOPPING);
        //Then
        System.out.println(shopping.getTaskName());
        assertEquals("Zakupy w biedronce",shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());
        System.out.println(shopping.executeTask());
        assertTrue(shopping.isTaskExecuted());
    }
    @Test
    void testFactoryPainting(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.makeTask(TaskFactory.PAINTING);
        //Then
        System.out.println(painting.getTaskName());
        assertEquals("Malowanie pokoju",painting.getTaskName());
        assertFalse(painting.isTaskExecuted());
        System.out.println(painting.executeTask());
        assertTrue(painting.isTaskExecuted());
    }
    @Test
    void testFactoryDriving(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.makeTask(TaskFactory.DRIVING);
        //Then
        System.out.println(driving.getTaskName());
        assertEquals("Pojechanie na wycieczke",driving.getTaskName());
        assertFalse(driving.isTaskExecuted());
        System.out.println(driving.executeTask());
        assertTrue(driving.isTaskExecuted());
    }
}
