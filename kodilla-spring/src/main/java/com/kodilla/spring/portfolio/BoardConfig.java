package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
/*
    @Autowired
    @Qualifier("TaskList1")
    TaskList b1 ;
    @Autowired
    @Qualifier("TaskList1")
    TaskList b2 ;
    TaskList b3 ;


    @Bean(name = "TaskList1")
    @Scope("prototype")
    public TaskList toDoList(){
        return new TaskList();
    }

    @Bean
    @Qualifier("taskList")
    public Board board(){
        Board board = new Board(taskList1, b2, taskList3);
        return board;
    }*/
}
