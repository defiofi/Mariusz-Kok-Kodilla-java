package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify (String Text , PoemDecorator aPoemDecorator){
        String BeautyText = aPoemDecorator.decorate(Text);
        System.out.println(BeautyText);
    }
}
