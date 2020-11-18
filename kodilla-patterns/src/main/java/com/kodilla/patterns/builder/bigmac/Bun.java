package com.kodilla.patterns.builder.bigmac;

public enum Bun {
    SESAME("bun with sesame seeds"),
    WITHOUT("bun without sesame");
    private String bun;
    Bun(String bun){
        this.bun = bun;
    }
    @Override
    public String toString(){
        return bun;
    }
}
