package com.kodilla.stream;

import com.kodilla.stream.beautifier.LambdaText;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;


public class MyExample {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");  //Pierwszy sposób przekazania
        processor.execute(codeToExecute);
        processor.execute(() -> System.out.println("This is an example text."));        // Drugi sposób przekazania
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
        System.out.println("Zadanie: upiększacz tekstów");
        PoemBeautifier aPoemDecorator = new PoemBeautifier();
        aPoemDecorator.beautify("Ala ma kota , a lolek psa.",(a) -> "ABC "+a+" ABC");
        aPoemDecorator.beautify("Wyrażenia lambda są tematem tego submodułu", String::toUpperCase);
        aPoemDecorator.beautify("A to mój pomysł na upiększenie tekstu.", String::toLowerCase);
        aPoemDecorator.beautify("Inny pomysł",(a) ->a+" jest rewelacyjny!!!");
        aPoemDecorator.beautify("AAA", LambdaText::multiplayText);
        aPoemDecorator.beautify("To jest dlugi tekst.", LambdaText::separatedText);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
