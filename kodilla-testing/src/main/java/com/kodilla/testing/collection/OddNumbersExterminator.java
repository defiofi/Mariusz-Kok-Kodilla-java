package com.kodilla.testing.collection;
import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        if (numbers.isEmpty()) {
            return numbers;
        }
        else {
            List<Integer> rezultat = new ArrayList<>();
            for(Integer entry : numbers){
                if (entry%2 == 0){
                    rezultat.add(entry);
                }
            }
            return rezultat;
        }
    }

}
