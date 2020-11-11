package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean(name = "taskList")
    @Scope("prototype")
    public TaskList toDoList(){
        return new TaskList();
    }

    @Bean
    @Qualifier("taskList")
    public Board board(TaskList taskList1, TaskList taskList2, TaskList taskList3){
        Board board = new Board(taskList1, taskList2, taskList3);
        return board;
    }
}
