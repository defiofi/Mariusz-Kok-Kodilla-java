package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {
    public static Map<String, Double> getTemperatures() {
        Map<String, Double> stubResult = new HashMap<>();

        // dummy data
        stubResult.put("Rzeszow", 25.5);
        stubResult.put("Krakow", 26.2);
        stubResult.put("Wroclaw", 24.8);
        stubResult.put("Warszawa", 25.2);
        stubResult.put("Gdansk", 26.1);

        return stubResult;
    }
    @Mock
    private Temperatures temperaturesMock;  //Zamiast: Temperatures TemperaturesMock = mock(Temperatures.class);

    @DisplayName("Test metody calculateForecast()")
    @Test
    void testCalculateForecastWithMock() {

        when(temperaturesMock.getTemperatures()).thenReturn(getTemperatures());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @DisplayName("Test metody averangeTemperature()")
    @Test
    void testAverageTemperatureWithMock() {

        when(temperaturesMock.getTemperatures()).thenReturn(getTemperatures());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double patern = 25.56;

        //Then
        Assertions.assertEquals(patern, weatherForecast.averangeTemperature());
    }
    @DisplayName("Test medody medianTemperature()")
    @Test
    void testMedianTemperatureWithMock() {

        when(temperaturesMock.getTemperatures()).thenReturn(getTemperatures());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast.medianTemperature();

        //Then

        Assertions.assertEquals(25.5, result);

    }
}
