package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantityZeroContinental(){
        //Given
        World ourWorld = new World();

        //When

        //Then
        assertEquals(0, ourWorld.getListOfContinents().size());
        assertEquals(BigDecimal.ZERO, ourWorld.getPeopleQuantity());
    }
    @Test
    void testGetPeopleQuantity(){
        //Given
        World ourWorld = new World();
        Continent europa = new Continent("Europa");
        europa.addCountry(new Country("Polska", new BigDecimal("38433000")));
        europa.addCountry(new Country("Niemcy", new BigDecimal("83020000")));
        europa.addCountry(new Country("Belgia", new BigDecimal("11460000")));
        europa.addCountry(new Country("Francja", new BigDecimal("66990000")));
        europa.addCountry(new Country("Włochy", new BigDecimal("60360000")));
        europa.addCountry(new Country("Hiszpania", new BigDecimal("46940000")));
        europa.addCountry(new Country("Szwecja", new BigDecimal("10230000")));
        europa.addCountry(new Country("Grecja", new BigDecimal("10720000")));
        europa.addCountry(new Country("Norwegia", new BigDecimal("5433000")));
        europa.addCountry(new Country("Wielka Brytania", new BigDecimal("66650000")));
        europa.addCountry(new Country("Austria", new BigDecimal("8859000")));
        europa.addCountry(new Country("Ukraina", new BigDecimal("41980000")));
        europa.addCountry(new Country("Rosja", new BigDecimal("144500000")));
        ourWorld.addContinent(europa);
        Continent azja = new Continent("Azja");
        azja.addCountry(new Country("Indie", new BigDecimal("1353000000")));
        azja.addCountry(new Country("Chiny", new BigDecimal("1393000000")));
        azja.addCountry(new Country("Japonia", new BigDecimal("126500000")));
        azja.addCountry(new Country("Mongolia", new BigDecimal("3170000")));
        azja.addCountry(new Country("Kazachstan", new BigDecimal("18280000")));
        ourWorld.addContinent(azja);
        Continent northAmerica = new Continent("Ameryka Północna");
        northAmerica.addCountry(new Country("United Stated of America", new BigDecimal("328200000")));
        northAmerica.addCountry(new Country("Kanada", new BigDecimal("37590000")));
        northAmerica.addCountry(new Country("Meksyk", new BigDecimal("126200000")));
        ourWorld.addContinent(northAmerica);

        //When
        long number = 38433000L+83020000L+11460000L+66990000L+60360000L+46940000L+10230000L+10720000L+5433000L+66650000L;
        number += 8859000L+41980000L+144500000l;
        number += 1353000000L+1393000000L+126500000L+3170000L+18280000L;
        number += 328200000L+37590000L+126200000L;
        BigDecimal exemplaryQuantity = BigDecimal.valueOf(number);

        //Then
        assertEquals(exemplaryQuantity, ourWorld.getPeopleQuantity());
    }
}
