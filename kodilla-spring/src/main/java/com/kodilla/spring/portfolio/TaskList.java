package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    TaskList(){
        this.tasks = new ArrayList<>();
    }
    public void addTask(String text){
        this.tasks.add(text);
    }
    public String getTask(int number){
        if (tasks.size()> number) {
            return tasks.get(number);
        } else {return null;}
    }
}
