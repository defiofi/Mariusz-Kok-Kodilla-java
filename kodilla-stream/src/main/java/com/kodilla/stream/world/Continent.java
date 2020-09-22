package com.kodilla.stream.world;

import java.util.LinkedList;
import java.util.List;

public class Continent {
    private final String nameOfContinent;
    private final List<Country> continentCountries = new LinkedList<>();

    public Continent(String nameOfContinent) {
        this.nameOfContinent = nameOfContinent;
    }

    public List<Country> getContinentCountries() {
        return continentCountries;
    }
    public void addCountry(Country country){
        continentCountries.add(country);
    }
}
