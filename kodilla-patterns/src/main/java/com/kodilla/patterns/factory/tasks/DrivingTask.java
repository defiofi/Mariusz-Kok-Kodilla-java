package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{
    private String taskName;
    private String where;
    private String using;
    private boolean taskExecuted = false;
    DrivingTask(String taskName, String where, String using){
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }
    public String executeTask(){
        String task = "Jade do "+where+" uzywajac "+using;
        taskExecuted = true;
        return task;
    }
    public String getTaskName(){
        return taskName;
    }
    public boolean isTaskExecuted(){
        return taskExecuted;
    }
}
