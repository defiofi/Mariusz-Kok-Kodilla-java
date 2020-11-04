package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightDatabase {
    private List<FlightDTO> dataBase = new ArrayList<>();
    FlightDatabase(){
        this.dataBase.add(new FlightDTO("Kraków", "Warszawa", 100.0));
        this.dataBase.add(new FlightDTO("Warszawa", "Kraków", 100.0));
        this.dataBase.add(new FlightDTO("Kraków", "Gdańsk", 150.0));
        this.dataBase.add(new FlightDTO("Gdańsk", "Kraków", 150.0));
        this.dataBase.add(new FlightDTO("Kraków", "Poznań", 80.0));
        this.dataBase.add(new FlightDTO("Poznań", "Kraków", 80.0));
        this.dataBase.add(new FlightDTO("Kraków", "Szczecin", 120.0));
        this.dataBase.add(new FlightDTO("Szczecin", "Kraków", 120.0));
        this.dataBase.add(new FlightDTO("Kraków", "Rzeszów", 70.0));
        this.dataBase.add(new FlightDTO("Rzeszów", "Kraków", 70.0));
        this.dataBase.add(new FlightDTO("Kraków", "Lublin", 80.0));
        this.dataBase.add(new FlightDTO("Lublin", "Kraków", 80.0));
        this.dataBase.add(new FlightDTO("Kraków", "Bydgoszcz", 110.0));
        this.dataBase.add(new FlightDTO("Bydgoszcz", "Kraków", 110.0));
        this.dataBase.add(new FlightDTO("Kraków", "Olsztyn", 130.0));
        this.dataBase.add(new FlightDTO("Olsztyn", "Kraków", 130.0));
        this.dataBase.add(new FlightDTO("Kraków", "Radom", 100.0));
        this.dataBase.add(new FlightDTO("Radom", "Kraków", 100.0));

        dataBase.add(new FlightDTO("Warszawa", "Gdańsk", 110.0));
        dataBase.add(new FlightDTO("Gdańsk", "Warszawa", 110.0));
        dataBase.add(new FlightDTO("Warszawa", "Poznań", 80.0));
        dataBase.add(new FlightDTO("Poznań", "Warszawa", 80.0));
        dataBase.add(new FlightDTO("Warszawa", "Szczecin", 100.0));
        dataBase.add(new FlightDTO("Szczecin", "Warszawa", 100.0));
        dataBase.add(new FlightDTO("Warszawa", "Rzeszów", 90.0));
        dataBase.add(new FlightDTO("Rzeszów", "Warszawa", 90.0));
        dataBase.add(new FlightDTO("Warszawa", "Katowice", 70.0));
        dataBase.add(new FlightDTO("Katowice", "Warszawa", 70.0));
        dataBase.add(new FlightDTO("Warszawa", "Lublin", 80.0));
        dataBase.add(new FlightDTO("Lublin", "Warszawa", 80.0));
        dataBase.add(new FlightDTO("Warszawa", "Bydgoszcz", 90.0));
        dataBase.add(new FlightDTO("Bydgoszcz", "Warszawa", 90.0));
        dataBase.add(new FlightDTO("Warszawa", "Olsztyn", 80.0));
        dataBase.add(new FlightDTO("Olsztyn", "Warszawa", 80.0));

        dataBase.add(new FlightDTO("Gdańsk", "Zielona Góra", 100.0));
        dataBase.add(new FlightDTO("Zielona Góra", "Gdańsk", 100.0));
        dataBase.add(new FlightDTO("Gdańsk", "Poznań", 90.0));
        dataBase.add(new FlightDTO("Poznań", "Gdańsk", 90.0));
        dataBase.add(new FlightDTO("Gdańsk", "Rzeszów", 80.0));
        dataBase.add(new FlightDTO("Rzeszów", "Gdańsk", 80.0));
        dataBase.add(new FlightDTO("Gdańsk", "Katowice", 130.0));
        dataBase.add(new FlightDTO("Katowice", "Gdańsk", 130.0));
        dataBase.add(new FlightDTO("Gdańsk", "Lublin", 110.0));
        dataBase.add(new FlightDTO("Lublin", "Gdańsk", 110.0));
        dataBase.add(new FlightDTO("Gdańsk", "Bydgoszcz", 90.0));
        dataBase.add(new FlightDTO("Bydgoszcz", "Gdańsk", 90.0));
        dataBase.add(new FlightDTO("Gdańsk", "Lódź", 100.0));
        dataBase.add(new FlightDTO("Lódź", "Gdańsk", 100.0));
        dataBase.add(new FlightDTO("Gdańsk", "Radom", 90.0));
        dataBase.add(new FlightDTO("Radom", "Gdańsk", 90.0));

    }
    public boolean addFlight(FlightDTO flightDTO){
        if (dataBase.contains(flightDTO)){
            return false;
        } else {
            dataBase.add(flightDTO);
            return true;
        }
    }
    public boolean deleteFlight(FlightDTO flightDTO){
        if (dataBase.contains(flightDTO)){
            dataBase.remove(flightDTO);
            return true;
        } else {
            return false;
        }
    }
    public void changeFlightDatabase(List<FlightDTO> dataBase){
        this.dataBase = dataBase;
    }
    public List<FlightDTO> searchDepartures(String city){
        List<FlightDTO> result = dataBase.stream().filter(FDTO->FDTO.getStartingPlace().equals(city)).
               collect(Collectors.toList());
        return result;
    }
    public List<FlightDTO> searchArrivals(String city) {
        List<FlightDTO> result = dataBase.stream().filter(FDTO->FDTO.getDestination().equals(city)).
                collect(Collectors.toList());
        return result;
    }
    public List<FlightWithInterstationDTO> searchFlight(String departure, String arrival){
        List<String> cities1 = dataBase.stream().filter(FDTO->FDTO.getStartingPlace().equals(departure)).
                map(FDTO->FDTO.getDestination()).collect(Collectors.toList());
        List<String> cities2 = dataBase.stream().filter(FDTO->FDTO.getDestination().equals(arrival)).
                map(FDTO->FDTO.getStartingPlace()).collect(Collectors.toList());
        List<String> interstation = cities1.stream().filter(u->cities2.contains(u)).collect(Collectors.toList());
        List<FlightDTO> list1 = dataBase.stream().filter(FDTO->FDTO.getStartingPlace().equals(departure)).
                filter(u->interstation.contains(u.getDestination())).collect(Collectors.toList());
        List<FlightDTO> list2 = dataBase.stream().filter(FDTO->FDTO.getDestination().equals(arrival)).
                filter(u->interstation.contains(u.getStartingPlace())).collect(Collectors.toList());
        List<FlightWithInterstationDTO> result = new ArrayList<>();
        for(int i = 0; i< interstation.size(); i++) {
            result.add(new FlightWithInterstationDTO(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
