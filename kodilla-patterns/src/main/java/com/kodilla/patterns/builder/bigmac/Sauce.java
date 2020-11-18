package com.kodilla.patterns.builder.bigmac;

public enum Sauce {
    STANDARD("standard"),
    THOUSAND("a thousand islands"),
    BARBECUE("barbecue");
    private String sauce;
    Sauce(String sauce) {
        this.sauce = sauce;
    }
    @Override
    public String toString(){
        return sauce;
    }
}
