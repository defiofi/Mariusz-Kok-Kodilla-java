package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()){

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }
    public double averangeTemperature(){
        double aT = 0;
        for (Map.Entry<String, Double>  temperatures : temperatures.getTemperatures().entrySet()){
            aT += temperatures.getValue();
        }
        aT = aT/this.temperatures.getTemperatures().size();
        return aT;
    }
    public double medianTemperature(){
        List<Double> table = new LinkedList<>();
        for (Map.Entry<String, Double>  temperatures : temperatures.getTemperatures().entrySet()){
            table.add(temperatures.getValue());
        }
        double moment = 0;
        for(int j = 0 ; j < table.size()-1 ; j++) {
            for (int i = 0; i < table.size() - 1; i++) {
                if (table.get(i) > table.get(i+1)) {
                    moment = table.get(i);
                    table.remove(i);
                    table.add(i+1, moment);
                }
            }
        }
        if (table.size()%2 == 0){ return (table.get(table.size()/2-1)+table.get(table.size()/2))/2; }
        else { return table.get(table.size()/2);}
    }
}
