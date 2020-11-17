package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(String typeOfTask){
        switch (typeOfTask){
            case DRIVING:
                return new DrivingTask("Pojechanie na wycieczke", "Debowice","rower");
            case PAINTING:
                return new PaintingTask("Malowanie pokoju","zielony", "pokoj dzieci");
            case SHOPPING:
                return new ShoppingTask("Zakupy w biedronce","Zubrowka" , 5);
            default:
                return null;
        }
    }
}
