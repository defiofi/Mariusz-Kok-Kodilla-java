package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static Double getAverage(int[] numbers){
        IntStream.range(0 ,numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);
       OptionalDouble a = IntStream.range(0 ,numbers.length)
               .map(n -> numbers[n])
                    .average();

        return a.orElse(0.0);
    }
}
