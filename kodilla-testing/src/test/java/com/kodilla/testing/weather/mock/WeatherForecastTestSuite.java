package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    void testCalculateForecastWithMock() {

        when(temperaturesMock.getTemperatures()).thenReturn(getTemperatures());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @Test
    void testAverageTemperatureWithMock() {

        when(temperaturesMock.getTemperatures()).thenReturn(getTemperatures());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double Averagetemperature = weatherForecast.calculateForecast().get("Rzeszow");
        Averagetemperature += weatherForecast.calculateForecast().get("Krakow");
        Averagetemperature += weatherForecast.calculateForecast().get("Wroclaw");
        Averagetemperature += weatherForecast.calculateForecast().get("Warszawa");
        Averagetemperature += weatherForecast.calculateForecast().get("Gdansk");
        double patern = (26.5+27.2+25.8+26.2+27.1)/5;
        //Then
        Averagetemperature = Averagetemperature/weatherForecast.calculateForecast().size();
        Assertions.assertEquals(patern, Averagetemperature);
    }
    @Test
    void testMedianTemperatureWithMock() {

        when(temperaturesMock.getTemperatures()).thenReturn(getTemperatures());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double[] table = new double[5];
        table[0] = weatherForecast.calculateForecast().get("Rzeszow");
        table[1] = weatherForecast.calculateForecast().get("Krakow");
        table[2] = weatherForecast.calculateForecast().get("Wroclaw");
        table[3] = weatherForecast.calculateForecast().get("Warszawa");
        table[4] = weatherForecast.calculateForecast().get("Gdansk");
        double moment = 0;
        for(int j = 0 ; j < weatherForecast.calculateForecast().size()-1 ; j++) {
            for (int i = 0; i < weatherForecast.calculateForecast().size() - 1; i++) {
                if (table[i + 1] > table[i]) {
                    moment = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = moment;
                }
            }
        }
        //Then
        double result = table[2];
        Assertions.assertEquals(26.5, result);

    }
}
