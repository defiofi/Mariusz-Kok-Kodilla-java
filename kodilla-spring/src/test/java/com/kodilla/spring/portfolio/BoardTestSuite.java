package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {
    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        context.getBean(Board.class).getToDoList().addTask("Pierwsze zadanie do wykonania.");
        context.getBean(Board.class).getInProgressList().addTask("Pierwsze zadanie w trakcie realizacji.");
        context.getBean(Board.class).getDoneList().addTask("Pierwsze zrealizowane zadanie.");
        System.out.println(context.getBean(Board.class).getToDoList().getTask(0));
        System.out.println(context.getBean(Board.class).getInProgressList().getTask(0));
        //Then
        assertEquals("Pierwsze zadanie do wykonania.",context.getBean(Board.class).getToDoList().getTask(0));
        assertEquals("Pierwsze zadanie w trakcie realizacji.",context.getBean(Board.class).getInProgressList().getTask(0));
        assertEquals("Pierwsze zrealizowane zadanie.", context.getBean(Board.class).getDoneList().getTask(0));

    }
    @Test
    void testBeanInContext(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        //Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
