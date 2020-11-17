package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    private String taskName;
    private String whatToBuy;
    private double quantity;
    private boolean taskExecuted = false;

    ShoppingTask(String taskName, String whatToBuy, double quantity){
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }
    public String executeTask(){
        String task = "Kupuje: "+quantity+" jednostek "+whatToBuy;
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
