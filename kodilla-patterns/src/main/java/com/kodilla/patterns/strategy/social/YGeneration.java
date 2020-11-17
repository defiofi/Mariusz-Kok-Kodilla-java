package com.kodilla.patterns.strategy.social;

public class YGeneration extends User{
    YGeneration(String name){
        super(name);
        this.socialPublisher = new TwitterPublisher();
    }
}
