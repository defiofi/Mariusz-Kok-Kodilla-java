package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private Map<String, Boolean> base = new HashMap<>();
    public boolean findFilght(Flight flight) throws RouteNotFoundException {
        if (base.containsKey(flight.getArrivalAirport())) {
            return base.get(flight.getArrivalAirport());
        }
        else {
        throw new RouteNotFoundException("Nie ma takiego lotniska");
        }
    }
    public void addConnection(String city, boolean connection){
        base.put(city,connection);
    }
}
