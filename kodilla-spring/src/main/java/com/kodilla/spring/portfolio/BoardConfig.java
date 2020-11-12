package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("TaskList1")
    TaskList taskList1 ;
    @Autowired
    @Qualifier("TaskList2")
    TaskList taskList2 ;
    @Autowired
    @Qualifier("TaskList3")
    TaskList taskList3 ;


    @Bean(name = "TaskList1")
    @Scope("prototype")
    public TaskList toDoList(){
        return new TaskList();
    }
    @Bean(name = "TaskList2")
    @Scope("prototype")
    public TaskList inProgressList(){
        return new TaskList();
    }
    @Bean(name = "TaskList3")
    @Scope("prototype")
    public TaskList doneList(){
        return new TaskList();
    }

    @Bean
    public Board board(){
        Board board = new Board(taskList1, taskList2, taskList3);
        return board;
    }
}
