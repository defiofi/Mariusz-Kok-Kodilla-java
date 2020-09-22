package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class World {
    private final List<Continent> wholeWorld = new LinkedList<>();


    public void addContinent(Continent continent){
        wholeWorld.add(continent);
    }
    public BigDecimal getPeopleQuantity(){                  // Do napisania
        BigDecimal sumOfAllPeople = wholeWorld.stream()
                .flatMap(continent -> continent.getContinentCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current) );
        return sumOfAllPeople;
    }
    public List<Continent> getListOfContinents(){
        return wholeWorld;
    }
}
