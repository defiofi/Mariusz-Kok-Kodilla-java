package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private Bun bun;
    private int burgers;
    private Sauce sauce;
    private List<Ingredient> ingredients;

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers = 0;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder chooseBun(Bun bun){
            this.bun = bun;
            return this;
        }
        public BigmacBuilder quantityBurgers(int burgers){
            this.burgers = burgers;
            return this;
        }
        public BigmacBuilder chooseSauce(Sauce sauce){
            this.sauce = sauce;
            return this;
        }
        public BigmacBuilder addIngredients(Ingredient ingredient){
            ingredients.add(ingredient);
            return this;
        }
        public Bigmac build(){
            if (bun != null && sauce != null) {
                return new Bigmac(bun, burgers, sauce, ingredients);
            } else {
                throw new IllegalStateException("Bigmac have to choosen bun and sauce!");
            }
        }
    }
    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients){
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }
    @Override
    public String toString(){
        String text = "Sklad Bigmac'a:\n\tbun = "+bun+"\n\tnumber of burgers = "+burgers+"\n\ttype of sauce = "+sauce
                +"\ningredients: \n";
        for (int i = 0 ; i< ingredients.size(); i++){
            text += "\t"+ingredients.get(i);
            text +="\n";
        }
        return text;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
