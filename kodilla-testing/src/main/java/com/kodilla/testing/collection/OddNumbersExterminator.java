package com.kodilla.testing.collection;
import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        if (numbers.isEmpty()) {
            return numbers;
        }
        else {      // Metoda do skończenia
            int liczba;
            List<Integer> rezultat = new ArrayList<>();
            for(Integer entry : numbers){
                liczba = entry;
                if (liczba%2 == 0){
                    rezultat.add(liczba);
                }
            }
            return rezultat;
        }
    }

}
