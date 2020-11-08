package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    TaskList toDoList;
    @Autowired
    TaskList inProgressList;
    @Autowired
    TaskList doneList;

    @Bean
    @Scope("prototype")
    public TaskList taskList(){
        return new TaskList();
    }

    @Bean
    @Scope("singleton")
    public Board board(){
        return new Board(toDoList, inProgressList, doneList);
    }
}
