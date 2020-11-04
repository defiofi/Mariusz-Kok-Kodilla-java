package com.kodilla.good.patterns.challenges.Flights;

public class FlightWithInterstationDTO {
    private FlightDTO flight1;
    private FlightDTO flight2;
    FlightWithInterstationDTO(FlightDTO flight1, FlightDTO flight2){
        this.flight1 = flight1;
        this.flight2 = flight2;
    }

    public FlightDTO getFlight1() {
        return flight1;
    }

    public FlightDTO getFlight2() {
        return flight2;
    }
}
