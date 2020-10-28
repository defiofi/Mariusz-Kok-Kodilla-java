package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class ShowAllTitle {
    public static void main(String[] Args){
        String movies = MovieStore.getMovies().entrySet().stream().
                flatMap(booksTitles->booksTitles.getValue().stream()).
                collect(Collectors.joining("!","",""));
        System.out.println(movies);
    }
}
