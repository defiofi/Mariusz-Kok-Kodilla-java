package com.kodilla.stream.beautifier;

public class LambdaText {
    public static String multiplayText(String text){
        String newText="";
        for(int i = 0 ; i < 5 ; i++){
            newText +=text+" ";
        }
        return newText;
    }
    public static String separatedText(String text){
        String newText="";
        for(int i = 1 ; i < text.length() ; i++){
            newText += text.substring(i-1 , i)+" ";
        }
        return newText;
    }
}
