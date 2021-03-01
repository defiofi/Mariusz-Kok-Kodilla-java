package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void testUpdate(){
        //Given
        StudentsTaskQueue bartosz = new StudentsTaskQueue("Bartosz");
        StudentsTaskQueue mariusz = new StudentsTaskQueue("Mariusz");
        StudentsTaskQueue cezary = new StudentsTaskQueue("Cezary");
        StudentsTaskQueue zbigniew = new StudentsTaskQueue("Zbigniew");
        Mentor piotrMentor = new Mentor("Piotr");
        Mentor pawelMentor = new Mentor("Pawel");
        bartosz.registerObserver(piotrMentor);
        mariusz.registerObserver(pawelMentor);
        cezary.registerObserver(pawelMentor);
        zbigniew.registerObserver(piotrMentor);

        //When
        bartosz.addTask("zadanie nr 1 z rozdziału nr 5");
        mariusz.addTask("zadanie nr 3 z rozdziału nr 7");
        cezary.addTask("zadanie nr 2 z rozdziału nr 1");
        zbigniew.addTask("zadanie nr 4 z rozdziału nr 2");
        bartosz.addTask("zadanie nr 2 z rozdziału nr 5");
        mariusz.addTask("zadanie nr 4 z rozdziału nr 7");
        cezary.addTask("zadanie nr 3 z rozdziału nr 1");
        bartosz.addTask("zadanie nr 3 z rozdziału nr 5");
        zbigniew.addTask("zadanie nr 1 z rozdziału nr 3");

        //Then
        assertEquals(4,pawelMentor.getUpdateCount());
        assertEquals(5,piotrMentor.getUpdateCount());
    }
    @Test
    public void testReadingStudentTaskQueue(){
        //Given
        StudentsTaskQueue bartosz = new StudentsTaskQueue("Bartosz");

        //When
        bartosz.addTask("zadanie nr 1 z rozdziału nr 5");
        bartosz.addTask("zadanie nr 2 z rozdziału nr 5");
        bartosz.addTask("zadanie nr 3 z rozdziału nr 5");

        //Then
        assertEquals("Bartosz", bartosz.getStudentName());
        assertEquals("zadanie nr 1 z rozdziału nr 5",bartosz.getTasks().get(0));
        assertEquals("zadanie nr 2 z rozdziału nr 5",bartosz.getTasks().get(1));
        assertEquals("zadanie nr 3 z rozdziału nr 5",bartosz.getTasks().get(2));
    }
    @Test
    public void testReadingMentor(){
        //Given
        Mentor piotrMentor = new Mentor("Piotr");
        StudentsTaskQueue bartosz = new StudentsTaskQueue("Bartosz");
        StudentsTaskQueue mariusz = new StudentsTaskQueue("Mariusz");
        bartosz.registerObserver(piotrMentor);
        mariusz.registerObserver(piotrMentor);

        //When
        bartosz.addTask("zadanie nr 1 z rozdziału nr 5");
        mariusz.addTask("zadanie nr 3 z rozdziału nr 7");
        bartosz.addTask("zadanie nr 2 z rozdziału nr 5");
        mariusz.addTask("zadanie nr 4 z rozdziału nr 7");

        //Then
        assertEquals("Piotr", piotrMentor.getMentorName());
        assertEquals(4,piotrMentor.getUpdateCount());
    }
}
