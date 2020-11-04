package com.kodilla.good.patterns.challenges.Flights;

import java.util.List;

public class FlightSearchMain {
    public static void main(String[] Args){
        FlightDatabase flightDatabase = new FlightDatabase();
        List<FlightDTO> resultDepartures =  flightDatabase.searchDepartures("Kraków");
        System.out.println("\n\tOdloty: ");
        show(resultDepartures);
        List<FlightDTO> resultArrivals = flightDatabase.searchArrivals("Warszawa");
        System.out.println("\n\tPrzyloty: ");
        show(resultArrivals);
        List<FlightWithInterstationDTO> result = flightDatabase.searchFlight("Gdańsk", "Warszawa");
        System.out.println("\n\tLoty przez inne miasto: ");
        show2(result);
    }
    public static void show(List<FlightDTO> list){
        for (FlightDTO flight : list){
            System.out.println("Miejsce odlotu: "+flight.getStartingPlace()+"\t\tMiejsce przylotu: "+flight.getDestination()+
                    "\t\tCena: "+flight.getPrice());
        }
    }
    public static void show2(List<FlightWithInterstationDTO> list){
        if (list.size()>0){
            for (FlightWithInterstationDTO flight : list) {
                System.out.println("Lot pierwszy: "+"\tMiejsce odlotu: "+flight.getFlight1().getStartingPlace()+"\tMiedzylądowanie: "+
                        flight.getFlight1().getDestination()+"\nLot drugi: "+ "\tMiejsce odlotu: "+flight.getFlight2().getStartingPlace()+
                        "\tMiejsce przylotu: "+flight.getFlight2().getDestination()+"\nCena całkowita: "+
                        (flight.getFlight1().getPrice()+flight.getFlight2().getPrice())+"\n");
            }
        } else {
            System.out.println("Brak lotów miedzy miastami z międzylądowaniem");
        }
    }
}
