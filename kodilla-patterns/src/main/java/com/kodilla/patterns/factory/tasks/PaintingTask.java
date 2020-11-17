package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{
    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean taskExecuted = false;
    PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }
    public String executeTask(){
        String task = "Maluje "+whatToPaint+" na kolor "+color;
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
