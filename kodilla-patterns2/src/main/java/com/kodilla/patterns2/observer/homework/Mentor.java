package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateCount = 0;

    public Mentor(String mentorName){
        this.mentorName = mentorName;
    }

    @Override
    public void update(StudentsTaskQueue studentsTaskQueue){
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
