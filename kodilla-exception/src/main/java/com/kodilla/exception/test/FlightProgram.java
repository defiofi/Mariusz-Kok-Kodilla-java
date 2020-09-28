package com.kodilla.exception.test;

public class FlightProgram {
    public static void main (String[] args){
        DataBase dataBase = new DataBase();

        dataBase.addConnection("Madryt",true);
        dataBase.addConnection("Barcelona",true);
        dataBase.addConnection("Moskwa",true);
        dataBase.addConnection("Berlin",true);
        dataBase.addConnection("Paryż",true);
        dataBase.addConnection("Ateny",true);
        dataBase.addConnection("Sztokholm",true);
        dataBase.addConnection("Londyn",true);
        dataBase.addConnection("Sztokholm",true);
        dataBase.addConnection("Ankara",true);
        dataBase.addConnection("Kijów",true);
        dataBase.addConnection("Lizbona",true);
        dataBase.addConnection("Wiedeń",true);

        Flight aFlight = new Flight("Warszawa" , "Madryt");
        Flight aBadFlight = new Flight("Warszawa" , "Kraków");
        try {
            if (dataBase.findFilght(aFlight)){
                System.out.println("Tak jest połączenie z "+ aFlight.getArrivalAirport());
            }
        }
        catch(RouteNotFoundException e){
            System.out.println(e);
        }
        try {
            if (dataBase.findFilght(aBadFlight)){
                System.out.println("Tak jest połączenie z "+ aFlight.getArrivalAirport());
            }
        }
        catch(RouteNotFoundException e){
            System.out.println(e);
        }
    }
}
