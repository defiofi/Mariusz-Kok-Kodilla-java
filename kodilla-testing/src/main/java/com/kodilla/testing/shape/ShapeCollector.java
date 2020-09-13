package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> figureColection = new ArrayList<>();
    public void addFigure(Shape shape){
        figureColection.add(shape);
    }
    public boolean removeFigure(Shape shape){
        if (this.getListLength() == 0) {return false;}
        else {
            figureColection.remove(shape);
            return true;
        }
    }
    public Shape getFigure(int n){
        if ((n < 0)||n >= getListLength()) {return null;}
        else {
            return figureColection.get(n);
        }
    }
    public String showFigures(){
        //zwracającą nazwy wszystkich figur w postaci jednego Stringa
        if (getListLength() == 0) {return null;}
        else {
            String text = "" ;
            for(int i = 0; i < getListLength(); i++){
                text += figureColection.get(i).getShapeName();
                if (i < getListLength()-1) {text +=" ";}
            }
            return text;}
    }
    public int getListLength(){ return figureColection.size(); }       //metoda do sprawdzenia działania klasy

}
