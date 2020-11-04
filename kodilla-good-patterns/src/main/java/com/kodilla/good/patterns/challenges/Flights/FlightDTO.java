package com.kodilla.good.patterns.challenges.Flights;

public class FlightDTO {
    private String startingPlace;
    private String destination;
    private Double price;

    public FlightDTO(final String startingPlace, final String destination, final Double price) {
        this.startingPlace = startingPlace;
        this.destination = destination;
        this.price = price;
    }

    public String getStartingPlace() {
        return startingPlace;
    }

    public String getDestination() {
        return destination;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightDTO flightDTO = (FlightDTO) o;

        if (startingPlace != null ? !startingPlace.equals(flightDTO.startingPlace) : flightDTO.startingPlace != null)
            return false;
        if (destination != null ? !destination.equals(flightDTO.destination) : flightDTO.destination != null)
            return false;
        return price != null ? price.equals(flightDTO.price) : flightDTO.price == null;
    }

    @Override
    public int hashCode() {
        int result = startingPlace != null ? startingPlace.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}

